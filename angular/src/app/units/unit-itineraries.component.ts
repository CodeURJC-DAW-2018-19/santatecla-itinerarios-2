import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';


import {LoginService} from '../login/login.service';
import {Unit, UnitService} from "./unit.service";
import { Itinerary } from '../itinerary/itinerary.service';
import { Content } from '../contents/content.service';

@Component({
    templateUrl: "unit-itineraries.component.html",
    styleUrls: ['unit-itineraries.component.css']
})
export class UnitItinerariesComponent {

    unit: Unit;
    itineraries: Itinerary[];
    contents: Content[];

    constructor(
        activatedRoute: ActivatedRoute,
        public service: UnitService,
        public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getUnit(id).subscribe(
            unit => this.unit = unit,
            error => console.error(error)
        );
        service.getUnitItineraries(id).subscribe(
            itineraries => this.itineraries = itineraries,
            error => console.error(error)
        );
        service.getUnitContents(id).subscribe(
            contents => this.contents = contents,
            error => console.error(error)
        );
    }
}
