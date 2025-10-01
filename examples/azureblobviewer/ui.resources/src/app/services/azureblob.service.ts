import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Azureblob } from '../models/azureblob';
import {environment} from "../../environments/environment";

import {Observable} from 'rxjs';

@Injectable()
export class AzureblobService {
  constructor(private httpClient: HttpClient) { }

  serverUrl : string = environment.BACKEND_URL + "/service/blobservice/azure/fetch";

  thumbnailFetchUrl : string = "https://southcentralus.api.cognitive.microsoft.com/vision/v2.0/generateThumbnail?width=100&height=100&smartCropp";

  value: any;

  getAllBlobs() {
    console.log("....AzureblobService.getAllBlobs()");
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept' : 'application/json'
    });

    return this.httpClient.post<Azureblob[]>(this.serverUrl,
      JSON.stringify({
        "azureAcountName": "acsazurestore",
        "azureAcountKey": "qjC6s44AmSbAkJ7Xqdsks/jjZDIYRTY8qgWKds8w8PXdL+Q08mU/yu3Oh/4wO3sYTwNgNiA6EG66gBRWBqMBNA==",
        "azureContainer":"acsazurecontainer"
      }),{headers: headers});
  }

  getBlobThumbnail(): Observable<Blob> {
    console.log("....AzureblobService.getBlobThumbnail()");
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Ocp-Apim-Subscription-Key': 'f78fdd51de304d99862c4a50c9a0ec0c'
    });

    return this.httpClient.post<Blob>(this.thumbnailFetchUrl,
      {
        "url": "http://acsazurestore.blob.core.windows.net/acsazurecontainer/Git-Logo-1788C.png"
      }, {headers: headers, responseType: 'blob' as 'json' });
  }
}
