import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators'

export interface Book {
  id?: number;
  title: string;
  description: string;
}

const URL = '/api/books/';
@Injectable()
export class BookService {

  constructor(private http: Http) { }

  getBooks() {
    return this.http.get(URL, { withCredentials: true })
      .pipe(
        map(response => response.json()),
        catchError(error => this.handleError(error))
      );
  }

  getBook(id: number | string) {
    return this.http.get(URL + id, { withCredentials: true })
      .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error))
      );
  }

  saveBook(book: Book) {

    const body = JSON.stringify(book);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    if (!book.id) {
      return this.http.post(URL, body, options)
        .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error))
        );
    } else {
      return this.http.put(URL + book.id, body, options)
        .pipe(
          map(response => response.json()),
          catchError(error => this.handleError(error)
        ));
    }
  }

  removeBook(book: Book) {

    const headers = new Headers({
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + book.id, options)
      .pipe(
        map(response => undefined),
        catchError(error => this.handleError(error))
      );
  }

  updateBook(book: Book) {

    const body = JSON.stringify(book);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.put(URL + book.id, body, options)
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
