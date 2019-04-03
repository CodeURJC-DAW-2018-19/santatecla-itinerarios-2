import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Content, ContentService} from "./content.service";
import {LoginService} from "../login/login.service";

@Component({
    template: `
  <div *ngIf="content">
  <h2> Editar contenido "{{content.title}}"</h2>
      <div *ngIf="content.hasImage" style="float: right; margin-right: 12.5%">
          <img src="data:image/JPEG;base64,{{content.imageRaw}}">
      </div>
      <form class="example-form" style="display: flex; flex-direction: column; width: 50%" >
          <mat-form-field>
              <input matInput placeholder="Título" value="{{content.title}}">
          </mat-form-field>
          <mat-form-field class="example-full-width">
              <textarea matInput placeholder="Descripción" value="{{content.desc}}" style="height: 5em"></textarea>
          </mat-form-field>
      </form>
  </div>
    <button mat-raised-button color="warn">Guardar</button>
`
})

export class ContentEdit {

    content: Content;
    constructor(private router: Router, activatedRoute: ActivatedRoute, public service: ContentService,
                public loginService: LoginService) {

        const id = activatedRoute.snapshot.params['id'];
        service.getContent(id).subscribe(
            content => this.content= content,
            error => console.error(error)
        );
    }

   /* removeBook() {
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
    }*/
}
