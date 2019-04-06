import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { LoginService } from '../auth/login.service';

export interface Unit {
  id?: number;
  name: string;
}

const URL = '/api/units/';
@Injectable()
export class UnitService {

  constructor(private loginService: LoginService, private http: Http) { }

  getUnits() {
    return this.http.get(URL, { withCredentials: true })
      .pipe(
        map(response => response.json()),
        catchError(error => this.handleError(error))
      );
  }

  getUnit(id: number | string) {
    return this.http.get(URL + id, { withCredentials: true })
      .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error))
      );
  }
  getUnitContents(id: number){
    return this.http.get(URL + id + "/contents" , {withCredentials: true})
        .pipe(
            map(response => response.json()),
            catchError(error => this.handleError(error))
        );
  }

  getUnitItineraries(id: number){
    return this.http.get(URL + id + "/itineraries" , {withCredentials: true})
        .pipe(
            map(response => response.json()),
            catchError(error => this.handleError(error))
        );
  }

  saveUnit(unit: Unit) {

    const body = JSON.stringify(unit);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    if (!unit.id) {
      return this.http.post(URL + 'newUnit', body, options)
        .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error))
        );
    } else {
      return this.http.put(URL + unit.id + '/update', body, options)
        .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error)
        ));
    }
  }

  removeUnit(unit: Unit) {

    const headers = new Headers({
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + unit.id + '/deleteUnit', options)
      .pipe(
        map(response => undefined),
        catchError(error => this.handleError(error))
      );
  }

  updateUnit(unit: Unit) {

    const body = JSON.stringify(unit);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.put(URL + unit.id, body, options)
      .pipe(
        map(response => response.json()), 
        catchError(error => this.handleError(error)),
      );
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }
}

