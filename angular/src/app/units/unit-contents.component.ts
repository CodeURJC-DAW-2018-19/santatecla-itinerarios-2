import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


import { LoginService } from '../auth/login.service';
import {Unit, UnitService} from "./unit.service";
import {Content, ContentService} from "../contents/content.service";
import {id} from "@swimlane/ngx-charts/release/utils";

@Component({
    templateUrl:"unit-contents.component.html"
})
export class UnitContentsComponent {

    unit: Unit;
    contents: Content[];
    constructor(private router: Router, activatedRoute: ActivatedRoute, public service: UnitService,
                public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getUnitContents(id).subscribe(
            contents => this.contents= contents,
            error => console.error(error)
        );
    }

    editUnit() {
        this.router.navigate(['/unit/edit', this.unit.id]);
    }
    editContent(id: number){
        this.router.navigate([this.router.url, 'edit', id])
    }
    gotoUnits() {
        this.router.navigate(['/units']);
    }

}
