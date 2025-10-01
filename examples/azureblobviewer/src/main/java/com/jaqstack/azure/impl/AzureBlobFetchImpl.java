package com.jaqstack.azure.impl;

import com.jaqstack.azure.models.AzureBlob;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.jaqstack.azure.AzureBlobFetch;
import java.security.InvalidKeyException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class AzureBlobFetchImpl implements AzureBlobFetch {
    private static final Logger logger = LogManager.getLogger(AzureBlobFetchImpl.class);

    @Override
    public void connect() {
        //@TODO
    }

    /**
     *
     */
    @Override
    public String fetchBlobs(String accountName, String accountKey, String containerName) {

        List<AzureBlob> azureBlobList = new ArrayList<>();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String connectionString = "DefaultEndpointsProtocol=https;"
                    + "AccountName=" + accountName + ";"
                    + "AccountKey=" + accountKey + ";"
                    + "EndpointSuffix=core.windows.net";

            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();

            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
            
            if (!containerClient.exists()) {
                throw new Exception("Container does not exist: " + containerName);
            }

            logger.info("\n\n******* Connected to Azure Blob Storage - container=" + containerName);

            // List all blobs in the container
            for (BlobItem blobItem : containerClient.listBlobs()) {
                logger.info("\n\n******* blobItem.getName()=" + blobItem.getName());
                
                String blobUrl = String.format("https://%s.blob.core.windows.net/%s/%s", 
                    accountName, containerName, blobItem.getName());
                
                azureBlobList.add(new AzureBlob(
                    blobItem.getName(),
                    blobUrl,
                    blobItem.getProperties().getContentType() != null ? 
                        blobItem.getProperties().getContentType() : "application/octet-stream"
                ));
            }

        } catch(InvalidKeyException ex) {
            logger.info("\n******* Invalid credentials", ex);
        } catch (Exception ex) {
            logger.info("\n******* buildProcess Exception", ex.getMessage());
        }

        return objGson.toJson(azureBlobList);
    }

}
