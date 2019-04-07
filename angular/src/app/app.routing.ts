import { RouterModule } from '@angular/router';

import { UnitFormComponent } from './units/unit-form.component';
import { UnitListComponent } from './units/unit-list.component';
import {UnitContentsComponent} from "./units/unit-contents.component";
import {ContentEdit} from "./contents/content-edit";
import { ItineraryComponent } from './itinerary/itinerary.component';
import { UnitItinerariesComponent } from './units/unit-itineraries.component';
import {ContentAdd} from "./contents/content-add";

const appRoutes = [
  { path: '', redirectTo: 'new/units', pathMatch: 'full' },
  { path: 'new/units', component: UnitListComponent, useAsDefault: true },
  { path: 'new/units/new', component: UnitFormComponent },
  { path: 'new/units/:id/contents', component: UnitContentsComponent},
  { path: 'new/units/:uId/contents/edit/:id', component: ContentEdit},
  { path: 'new/itinerary', component: ItineraryComponent},
  { path: 'new/units/:id/itineraries', component: UnitItinerariesComponent},
  { path: 'new/units/:id/addContent', component: ContentAdd}
];

export const routing = RouterModule.forRoot(appRoutes);
