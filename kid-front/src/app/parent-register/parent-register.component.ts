import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUser } from '../models/CurrentUser';
import { ParentRegisterModel } from '../models/ParentRegisterModel';

import { ParentRegisterService } from '../services/parent-register.service';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-parent-register',
  templateUrl: './parent-register.component.html',
  styleUrls: ['./parent-register.component.css']
})
export class ParentRegisterComponent implements OnInit {

  alert = false;
  user: CurrentUser;
  model: any = {};
  constructor(private parentRegisterService: ParentRegisterService,
    private currentUserService: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.user = user);
  }

  parentRegister() {
    this.alert = false;
    this.parentRegisterService.register(new ParentRegisterModel(this.model))
      .subscribe(
        data => {
          this.currentUserService.changeUser(new CurrentUser(data));
          this.router.navigate(['/']);
        },
        error => {
          this.alert = true;
          this.model.error = error;
        }
      );
  }
}
