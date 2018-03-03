import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUser } from '../models/CurrentUser';

import { UserLoginService } from '../services/user-login.service';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user: CurrentUser;
  alert = false;
  model: any = {};
  constructor( private loginService: UserLoginService , private router: Router , private currentUserService: CurrentUserService) {}

  ngOnInit() {
    this.model.mode = 'parent';
    this.currentUserService.currentUser.subscribe(user => this.user = user);
  }

  login() {
    this.alert = false;
    this.loginService.login(this.model.username, this.model.password, this.model.mode)
      .subscribe(
        data => {
          this.currentUserService.changeUser(new CurrentUser(data));
          this.router.navigate(['/']);
        },
        error => {
          this.alert = true;
          this.model.error = error.error;
        }
      );
  }

  reset() {
    this.loginService.reset(this.model.username, this.model.mode)
      .subscribe(
        data => {
          this.alert = true;
        },
        error => {
          this.model.error = error.error;
        }
      );
  }
}
