import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LoginService } from '../login/login.service';
import { Itinerary, ItineraryService } from './itinerary.service';

@Component({
  templateUrl: 'itinerary.component.html'
})
export class ItineraryComponent implements OnInit {

  itineraries: Itinerary[];

  constructor(
    private router: Router,
    private service: ItineraryService,
    public loginService: LoginService) {}

  ngOnInit() {
    this.service.getItineraries().subscribe(
      itineraries => this.itineraries = itineraries,
      error => console.log(error));
  }

  newContent() {
    this.router.navigate(['new/itineraries/new']);
}
}
