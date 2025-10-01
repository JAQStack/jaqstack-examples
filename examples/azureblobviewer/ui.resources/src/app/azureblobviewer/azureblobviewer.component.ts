import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import {AzureblobService} from "../services/azureblob.service";
import { DomSanitizer, SafeUrl } from "@angular/platform-browser";

@Component({
  selector: 'app-azureblobviewer',
  templateUrl: './azureblobviewer.component.html',
  styleUrls: ['./azureblobviewer.component.css'],
  providers: [ AzureblobService]
})
export class AzureBlobViewerComponent implements OnInit {

  blobsList : any;
  imageBlobUrl: string | null = null;
  sanitizedImageBlobUrl: SafeUrl | null = null;

  constructor(private azureblobService : AzureblobService,
              private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getAllBlobs();
    this. getThumbnail();
  }

  getAllBlobs() : void {
    this.azureblobService.getAllBlobs()
      .subscribe(
        (val) => {
          this.blobsList = val; //<====== Set value here
        },
        response => {
          console.log("POST - getAllBlobs in error", response);
        },
        () => {
          console.log("POST - getAllBlobs is now completed.");
        });
  }

  getThumbnail() : void {
    this.azureblobService.getBlobThumbnail()
      .subscribe(
        (val) => {
          console.log("POST - getThumbnail- successful value returned in body", val);
          //this.turl = val; //<====== Set value here
          this.createImageFromBlob(val);
        },
        response => {
          console.log("POST - getThumbnail - in error", response);
        },
        () => {
          console.log("POST - getThumbnail - observable is now completed.");
        });
  }

  createImageFromBlob(image: Blob) {
    console.log("Call createImageFromBlob()", image);
    let reader = new FileReader();
    reader.addEventListener("load", () => {
      this.imageBlobUrl = reader.result as string;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

}
