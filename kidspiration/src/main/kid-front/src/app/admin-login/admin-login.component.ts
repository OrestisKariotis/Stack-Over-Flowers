import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUser } from '../models/CurrentUser';

import { AdminService } from '../services/admin.service';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  model: any = {};
  constructor(private adminService: AdminService, private currentUserService: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  adminlogin() {
    this.adminService.login(this.model.username, this.model.password)
      .subscribe(
        data => {
          const user = new CurrentUser(data);
          user.mode = 'admin';
          user.enable = true;
          sessionStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserService.changeUser(user);
          this.router.navigate(['/control-panel']);
        },
        error => {
          this.router.navigate(['/']);
        }
      );
  }

}
