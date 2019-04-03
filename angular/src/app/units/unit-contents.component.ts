import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


import { LoginService } from '../login/login.service';
import {Unit, UnitService} from "./unit.service";
import {Content} from "../contents/content.service";

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

    removeUnit() {
        const okResponse = window.confirm('Do you want to remove this book?');
        if (okResponse) {
            this.service.removeUnit(this.unit).subscribe(
                _ => this.router.navigate(['/books']),
                error => console.error(error)
            );
        }
    }

    editUnit() {
        this.router.navigate(['/unit/edit', this.unit.id]);
    }
    gotoUnits() {
        this.router.navigate(['/units']);
    }
}
