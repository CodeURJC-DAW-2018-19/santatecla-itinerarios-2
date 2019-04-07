import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';


import {LoginService} from '../login/login.service';
import {Unit, UnitService} from "./unit.service";
import {Content, ContentService} from "../contents/content.service";
import {id} from "@swimlane/ngx-charts/release/utils";

@Component({
    templateUrl: "unit-contents.component.html",
    styleUrls: ['../contents/contents-style.css', 'tabs.css']
})
export class UnitContentsComponent {

    unit: Unit;
    contents: Content[];

    constructor(private router: Router, private activatedRoute: ActivatedRoute, public service: UnitService,
                public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getUnitContents(id).subscribe(
            contents => this.contents = contents,
            error => console.error(error)
        );
        // Need it for tabs
        service.getUnit(id).subscribe(
            unit => this.unit = unit,
            error => console.error(error)
        );
    }

    addContent() {
        let id = this.activatedRoute.snapshot.params['id'];
        this.router.navigate(['new/units/' + id + '/addContent'])
    }

    editUnit() {
        this.router.navigate(['/unit/edit', this.unit.id]);
    }

    editContent(id: number) {
        this.router.navigate([this.router.url, 'edit', id])
    }

    gotoUnits() {
        this.router.navigate(['/units']);
    }

}
