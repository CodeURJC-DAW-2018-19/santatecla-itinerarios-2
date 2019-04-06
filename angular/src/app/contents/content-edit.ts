import { Component , OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Content, ContentService} from "./content.service";
import {LoginService} from "../auth/login.service";
import {Headers, RequestOptions} from "@angular/http";
import {catchError, map} from "rxjs/operators";
import {Book} from "../book.service";
import {HttpClient} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
    templateUrl:"content-edit.html"
})

export class ContentEdit {
    selectedFile: File = null;
    content: Content;

    constructor(private http: HttpClient, private router: Router, public activatedRoute: ActivatedRoute, public service: ContentService, public sanitizer:DomSanitizer,
                public loginService: LoginService) {

    }
    ngOnInit(){
        const idd = this.activatedRoute.snapshot.params['id'];
        this.service.getContent(idd).subscribe(
            content => this.content= content,
            error => console.error(error)
        );
    }

    saveContent() {
        this.service.editContent(this.content).subscribe(
            content => { },
            error => console.error('Error creating new content: ' + error)
        );
        window.history.back();
    }
    saveImage(){
            const fd = new FormData();
            fd.append('file', this.selectedFile);
            this.http.post("/api/contents/" + this.content.id + "/img", fd)
                .subscribe(res => {
                    console.log(res);
                    this.ngOnInit();
                })
    }
    removeContent(){
        const okResponse = window.confirm('Do you want to remove this content?');
        if (okResponse) {
            this.service.deleteContent(this.content.id).subscribe(
                _ => this.router.navigate(['/new/units']),
                error => console.error(error)
            );
        }
    }

    onfFileSelected(event){
        console.log(event);
        this.selectedFile = <File>event.target.files[0];
    }
   /* removeBook() {
        const okResponse = window.confirm('Do you want to remove this book?');
        if (okResponse) {
            this.service.removeBook(this.book).subscribe(
                _ => this.router.navigate(['/books']),
                error => console.error(error)
            );
        }
    }
*/

    /* gotoBooks() {
        this.router.navigate(['/books']);
    }*/
}
