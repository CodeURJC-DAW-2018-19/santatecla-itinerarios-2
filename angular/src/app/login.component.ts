import { Component, ViewChild, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { MatDialog, MatDialogRef } from '@angular/material';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  @ViewChild('loginDialog') loginDialog: TemplateRef<any>;
  dialogRef: MatDialogRef<any, any>;

  constructor(public dialog: MatDialog,
      private loginService: LoginService) { }

  logIn(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.logIn(user, pass).subscribe(
      u => {
        console.log(u);
        this.dialogRef.close();
      },
      error => alert('Invalid user or password')
    );
  }

  logOut() {
    this.loginService.logOut().subscribe(
      response => { },
      error => console.log('Error when trying to log out: ' + error)
    );
  }

  openLoginDialog(){
    this.dialogRef = this.dialog.open(this.loginDialog, {
        width: '50%',
        height: '50%',
      });
}

}
