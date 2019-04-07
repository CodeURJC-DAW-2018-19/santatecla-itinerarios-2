import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators'
import {Unit} from "../units/unit.service";

export interface Itinerary {
  id?: number;
  name: string;
  unit: Unit;
}

const URL = '/api/itinerary/';
@Injectable()
export class ItineraryService {

  constructor(private http: Http) { }

  getItineraries() {
    return this.http.get(URL, { withCredentials: true })
            .pipe(
                map(response => response.json()),
                catchError(error => this.handleError(error))
            );
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }
}

