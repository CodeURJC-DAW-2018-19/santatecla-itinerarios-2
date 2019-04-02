import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Unit, UnitService } from './unit.service';
import { LoginService } from '../login/login.service';

@Component({
  templateUrl: 'unit-list.component.html'
})
export class UnitListComponent implements OnInit {

  units: Unit[];

  constructor(private router: Router, private service: UnitService,
    public loginService: LoginService) { }

  ngOnInit() {
    this.service.getUnits().subscribe(
      units => this.units = units,
      error => console.log(error)
    );
  }

  newUnit() {
    this.router.navigate(['new/units/new']);
  }
}
