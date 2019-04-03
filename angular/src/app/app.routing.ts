import { Routes, RouterModule } from '@angular/router';

import { BookListComponent } from './book-list.component';
import { BookDetailComponent } from './book-detail.component';
import { BookFormComponent } from './book-form.component';
import { UnitListComponent } from './units/unit-list.component';
import { ContentListComponent} from "./contents/content-list.component";
import {UnitContentsComponent} from "./units/unit-contents.component";
import {ContentEdit} from "./contents/content-edit";

const appRoutes = [
  /*{ path: 'books', component: BookListComponent },
  { path: 'book/new', component: BookFormComponent },
  { path: 'book/:id', component: BookDetailComponent },
  { path: 'book/edit/:id', component: BookFormComponent },*/
  { path: '', redirectTo: 'new/units', pathMatch: 'full' },
  { path: 'new/units', component: UnitListComponent, useAsDefault: true },
  { path: 'new/contents', component: ContentListComponent},
  { path: 'new/units/:id/contents', component: UnitContentsComponent},
  { path: 'new/units/:id/contents/edit/:id', component: ContentEdit}
];

export const routing = RouterModule.forRoot(appRoutes);
