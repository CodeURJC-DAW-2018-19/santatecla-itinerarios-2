import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Book, BookService } from './book.service';
import { LoginService } from './login.service';

@Component({
    template: `
  <div *ngIf="book">
  <h2>Book "{{book.title}}"</h2>
  <div>
    <p>{{book.description}}</p>
  </div>
  <p>
    <button *ngIf="loginService.isLogged && loginService.isAdmin" (click)="removeBook()">Remove</button>
    <button *ngIf="loginService.isLogged" (click)="editBook()">Edit</button>
    <br>
    <button (click)="gotoBooks()">All Books</button>
  </p>
  </div>`
})
export class BookDetailComponent {

    book: Book;

    constructor(private router: Router, activatedRoute: ActivatedRoute, public service: BookService,
        public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getBook(id).subscribe(
            book => this.book = book,
            error => console.error(error)
        );
    }

    removeBook() {
        const okResponse = window.confirm('Do you want to remove this book?');
        if (okResponse) {
            this.service.removeBook(this.book).subscribe(
                _ => this.router.navigate(['/books']),
                error => console.error(error)
            );
        }
    }

    editBook() {
        this.router.navigate(['/book/edit', this.book.id]);
    }

    gotoBooks() {
        this.router.navigate(['/books']);
    }
}
