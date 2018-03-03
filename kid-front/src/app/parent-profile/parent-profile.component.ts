import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { ParentService } from '../services/parent.service';

import { CurrentUser } from '../models/currentUser';

@Component({
  selector: 'app-parent-profile',
  templateUrl: './parent-profile.component.html',
  styleUrls: ['./parent-profile.component.css']
})
export class ParentProfileComponent implements OnInit {

  currentUser: CurrentUser;
  currentTickets: any; //lista tickets
  model: any = {};
  constructor(private currentUserService: CurrentUserService, private parentService: ParentService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.currentUser = user);
    this.model.phone = this.currentUser.phone;
  }

  updateParent() {
    if (this.model.phone !== this.currentUser.phone) {
      this.parentService.updateParent(this.currentUser.id, this.model.phone)
        .subscribe(
        data => {
          this.currentUser.phone = data.phone;
          this.currentUserService.changeUser(this.currentUser);
        },
        error => {
          //this.alert = true;
          this.model.error = error;
        }
      );
    }
  }

  getCurrTickets() {
    this.parentService.getCurrTickets(this.currentUser.id)
      .subscribe(
      data => {
        this.currentTickets = data;
      },
      error => {
        this.model.error = error;
      }
    );
  }
}
