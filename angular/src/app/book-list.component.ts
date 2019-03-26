import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Book, BookService } from './book.service';
import { LoginService } from './login.service';

@Component({
  templateUrl: 'book-list.component.html'
})
export class BookListComponent implements OnInit {

  books: Book[];

  constructor(private router: Router, private service: BookService,
    public loginService: LoginService) { }

  ngOnInit() {
    this.service.getBooks().subscribe(
      books => this.books = books,
      error => console.log(error)
    );
  }

  newBook() {
    this.router.navigate(['/book/new']);
  }
}
