import { Routes, RouterModule } from '@angular/router';

import { BookListComponent } from './book-list.component';
import { BookDetailComponent } from './book-detail.component';
import { UnitFormComponent } from './units/unit-form.component';
import { UnitListComponent } from './units/unit-list.component';
import { ContentListComponent} from "./contents/content-list.component";
import {UnitContentsComponent} from "./units/unit-contents.component";
import {ContentEdit} from "./contents/content-edit";
import { ItineraryComponent } from './itinerary/itinerary.component';
import { UnitItinerariesComponent } from './units/unit-itineraries.component';

const appRoutes = [
  /*{ path: 'books', component: BookListComponent },
  { path: 'book/new', component: BookFormComponent },
  { path: 'book/:id', component: BookDetailComponent },
  { path: 'book/edit/:id', component: BookFormComponent },*/
  { path: '', redirectTo: 'new/units', pathMatch: 'full' },
  { path: 'new/units', component: UnitListComponent, useAsDefault: true },
  { path: 'new/units/new', component: UnitFormComponent },
  { path: 'new/contents', component: ContentListComponent},
  { path: 'new/units/:id/contents', component: UnitContentsComponent},
  { path: 'new/units/:id/contents/edit/:id', component: ContentEdit},
  { path: 'new/itinerary', component: ItineraryComponent},
  { path: 'new/units/:id/itineraries', component: UnitItinerariesComponent}
];

export const routing = RouterModule.forRoot(appRoutes);
