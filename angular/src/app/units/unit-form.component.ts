import {Component} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Unit, UnitService} from './unit.service';

@Component({
    template: `
        <div *ngIf="unit">
            <h2>Crear una nueva unidad</h2>
            <div *ngIf="unit.id">
                <label>Id: </label>{{unit.id}}
            </div>
            <div>
                <mat-form-field>
                    <input [(ngModel)]="unit.name" matInput placeholder="Título">
                </mat-form-field>
                <p>
                    <button mat-raised-button color="warn" (click)="cancel()">Cancelar</button>
                    <button mat-raised-button color="warn" (click)="save()" style="margin: 10px">Guardar unidad</button>
                </p>
            </div>
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
            this.unit = {name: ''};
            this.newUnit = true;
        }
    }

    cancel() {
        window.history.back();
    }

    save() {
        this.service.saveUnit(this.unit).subscribe(
            unit => {
            },
            error => console.error('Error creating new unit: ' + error)
        );
        window.history.back();
    }
}
