import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Content, ContentService} from "./content.service";
import {LoginService} from "../login/login.service";
import {Headers, RequestOptions} from "@angular/http";
import {catchError, map} from "rxjs/operators";
import {Book} from "../book.service";
import {HttpClient} from "@angular/common/http";

@Component({
    templateUrl:"content-edit.html"
})

export class ContentEdit {
    selectedFile: File = null;
    content: Content;
    constructor(private http: HttpClient, private router: Router, activatedRoute: ActivatedRoute, public service: ContentService,
                public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getContent(id).subscribe(
            content => this.content= content,
            error => console.error(error)
        );
    }

    saveContent() {
        this.service.editContent(this.content).subscribe(
            content => { },
            error => console.error('Error creating new book: ' + error)
        );
    }
    saveImage(){
        /*this.service.editImage(this.content).subscribe(
            content => { },
            error => console.error('Error creating new book: ' + error)
        );
        window.history.back();*/
        const fd = new FormData();
        fd.append('file',this.selectedFile);
        this.http.post("/api/contents/" + this.content.id + "/img", fd)
            .subscribe(res => {
                console.log(res);
                window.history.back();
            })
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
