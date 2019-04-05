import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Unit, UnitService } from './unit.service';

@Component({
  template: `
  <div *ngIf="unit">
  <h2>Unidad "{{unit.name}}"</h2>
  <div *ngIf="unit.id">
    <label>Id: </label>{{unit.id}}
  </div>
  <div>
    <label>Titulo: </label>
    <input [(ngModel)]="unit.name" placeholder="name"/>
  </div>
  <p>
    <button (click)="cancel()">Cancel</button>
    <button (click)="save()">Save</button>
  </p>
  </div>`
})
export class UnitFormComponent {

  newUnit: boolean;
  unit: Unit;

  constructor(
    private _router: Router,
    activatedRoute: ActivatedRoute,
    private service: UnitService) {

    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      service.getUnit(id).subscribe(
        unit => this.unit = unit,
        error => console.error(error)
      );
      this.newUnit = false;
    } else {
      this.unit = { name: ''};
      this.newUnit = true;
    }
  }

  cancel() {
    window.history.back();
  }

  save() {
    this.service.saveUnit(this.unit).subscribe(
      unit => { },
      error => console.error('Error creating new unit: ' + error)
    );
    window.history.back();
  }
}
