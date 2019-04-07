import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Content, ContentService} from "./content.service";
import {LoginService} from "../auth/login.service";
import {HttpClient} from "@angular/common/http";

@Component({
    templateUrl: "content-edit.html",
    styleUrls: ['../contents/contents-style.css']
})

export class ContentEdit {
    selectedFile: File = null;
    content: Content;

    constructor(private http: HttpClient, private router: Router, public activatedRoute: ActivatedRoute, public service: ContentService,
                public loginService: LoginService) {

    }

    ngOnInit() {
        const id = this.activatedRoute.snapshot.params['id'];
        this.service.getContent(id).subscribe(
            content => this.content = content,
            error => console.error(error)
        );
    }

    saveContent() {
        this.service.updateContent(this.content).subscribe(
            content => {
            },
            error => console.error('Error creating new content: ' + error)
        );
        window.history.back();
    }

    saveImage() {
        const fd = new FormData();
        fd.append('file', this.selectedFile);
        this.http.post("/api/contents/" + this.content.id + "/img", fd)
            .subscribe(res => {
                console.log(res);
                this.ngOnInit();
            })
    }

    removeContent() {
        const okResponse = window.confirm('Do you want to remove this content?');
        if (okResponse) {
            let uId = this.activatedRoute.snapshot.params['uId'];
            this.service.deleteContent(this.content.id).subscribe(
                _ => this.router.navigate(['/new/units/' + uId + '/contents']),
                error => console.error(error)
            );
        }
    }

    onfFileSelected(event) {
        console.log(event);
        this.selectedFile = <File>event.target.files[0];
    }

}
