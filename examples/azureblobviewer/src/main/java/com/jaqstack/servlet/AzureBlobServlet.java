package com.jaqstack.servlet;

import com.jaqstack.azure.impl.AzureBlobFetchImpl;
import com.jaqstack.azure.models.AzureBlobStorage;

import jakarta.servlet.ServletException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/blobservice/azure")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AzureBlobServlet {

    //private String accountContainerName = "acsazurecontainer";

    @POST
    @Path("/fetch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String fetchBlobsURLs(AzureBlobStorage azureBlobStorage) throws ServletException {
        AzureBlobFetchImpl azureBlobFetch = new AzureBlobFetchImpl();

        return azureBlobFetch.fetchBlobs(azureBlobStorage.getAzureAcountName(), azureBlobStorage.getAzureAcountKey(), azureBlobStorage.getAzureContainer());
    }
}