import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from '../login.service';
import {Content, ContentService} from "./content.service";

@Component({
    templateUrl: 'content-list.component.html'
})
export class ContentListComponent implements OnInit {

    contents: Content[];

    constructor(private router: Router, private service: ContentService,
                public loginService: LoginService) { }

    ngOnInit() {
        this.service.getContents().subscribe(
            contents => this.contents = contents,
            error => console.log(error)
        );
    }

    newUnit() {
        this.router.navigate(['new/contents/new']);
    }
}
