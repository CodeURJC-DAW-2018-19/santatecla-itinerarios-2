import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators'
import {Unit} from "../units/unit.service";

export interface Content {
    id?: number;
    title: string;
    desc: string;
    hasImage:boolean;
    unit:Unit;
    imageRaw: Blob;
}

const URL = '/api/contents/';
@Injectable()
export class ContentService {

    constructor(private http: Http) { }

    getContents() {
        return this.http.get(URL, { withCredentials: true })
            .pipe(
                map(response => response.json()),
                catchError(error => this.handleError(error))
            );
    }

    getContent(id: number | string) {
        return this.http.get(URL + id, { withCredentials: true })
            .pipe(
                map(response => response.json()),
                catchError(error => this.handleError(error))
            );
    }


    editContent(content: Content) {
        const body = JSON.stringify(content);
        const headers = new Headers({
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        });
        const options = new RequestOptions({ withCredentials: true, headers });

        if (!content.id) {
            return this.http.post(URL + content.id, body, options)
                .pipe(
                    map(response => response.json()),
                    catchError(error => this.handleError(error))
                );
        } else {
            return this.http.put(URL + content.id, body, options)
                .pipe(
                    map(response => response.json()),
                    catchError(error => this.handleError(error)
                    ));
        }
    }

    removeContent(content: Content) {

        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });
        const options = new RequestOptions({ withCredentials: true, headers });

        return this.http.delete(URL + content.id, options)
            .pipe(
                map(response => undefined),
                catchError(error => this.handleError(error))
            );
    }

    updateContent(content: Content) {

        const body = JSON.stringify(content);
        const headers = new Headers({
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        });
        const options = new RequestOptions({ withCredentials: true, headers });

        return this.http.put(URL + content.id, body, options)
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
