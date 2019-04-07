import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Content, ContentService} from "./content.service";
import {LoginService} from "../auth/login.service";
import {Headers, RequestOptions} from "@angular/http";
import {catchError, map} from "rxjs/operators";
import {Book} from "../book.service";
import {HttpClient} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";
import {Unit, UnitService} from "../units/unit.service";


@Component({
    templateUrl: "content-add.html",
    styleUrls: ['../contents/contents-style.css']
})

export class ContentAdd {
    content: Content;
    newContent: boolean;
    selectedFile: File;

    constructor(private http: HttpClient, private router: Router, private activatedRoute: ActivatedRoute, private contentService: ContentService, public unitService: UnitService,
                public loginService: LoginService) {
        this.content = {
            title: '',
            desc: '',
            hasImage: false,
        }

    }

    save() {
        this.contentService.addContent(this.content, this.activatedRoute.snapshot.params['id']).subscribe(
            content => {
            },
            error => console.error('Error creating new unit: ' + error)
        );
        window.history.back();
    }

    onfFileSelected(event) {
        console.log(event);
        this.selectedFile = <File>event.target.files[0];
    }

    saveImage() {
        const fd = new FormData();
        fd.append('file', this.selectedFile);
        this.http.post("/api/contents/" + this.content.id + "/img", fd)
            .subscribe(res => {
                console.log(res);
            })
    }
}