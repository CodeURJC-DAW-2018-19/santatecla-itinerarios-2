import { Routes, RouterModule } from '@angular/router';

import { BookListComponent } from './book-list.component';
import { BookDetailComponent } from './book-detail.component';
import { BookFormComponent } from './book-form.component';
import { UnitListComponent } from './units/unit-list.component';

const appRoutes = [
  { path: 'books', component: BookListComponent },
  { path: 'book/new', component: BookFormComponent },
  { path: 'book/:id', component: BookDetailComponent },
  { path: 'book/edit/:id', component: BookFormComponent },
  { path: '', redirectTo: 'books', pathMatch: 'full' },
  { path: 'units', component: UnitListComponent, useAsDefault: true }
];

export const routing = RouterModule.forRoot(appRoutes);
