import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { ProviderService } from '../services/provider.service';
import { EventService } from '../services/event.service';
import { ActivatedRoute } from '@angular/router';
import { ProviderViewEventModel } from '../models/EventModel';

import { CurrentUser } from '../models/CurrentUser';
import { TicketsModel } from '../models/PurchaseModel';

@Component({
  selector: 'app-provider-profile',
  templateUrl: './provider-profile.component.html',
  styleUrls: ['./provider-profile.component.css']
})
export class ProviderProfileComponent implements OnInit {

  currentUser: CurrentUser;
  hide: boolean;
  activities: ProviderViewEventModel[] = [];
  model: any = {};
  thisPublicProvider: CurrentUser;
  thisPrivateProvider: CurrentUser;
  thisId: number;
  constructor(private currentUserService: CurrentUserService, private providerService: ProviderService, private route: ActivatedRoute,
    private eventService: EventService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.currentUser = user);
    this.thisId = +this.route.snapshot.paramMap.get('id');
    if (this.currentUser.mode === 'parent' || this.thisId !== this.currentUser.id) {
      //this.clear(['priv1', 'priv2', 'priv3', 'personal', 'tickets', 'monthly-reports']);
    }
    this.providerService.getPublicProvider(this.thisId)
    .subscribe(
      data => {
        this.thisPublicProvider = data;
      },
      error => {
        this.model.error = error.error;
      }
    );
  }

  clear(strlst: string[]) {
    for (let str of strlst) {
      let node = window.document.getElementById(str);
      let clone = node.cloneNode(false);
      node.parentNode.replaceChild(clone , node);
      window.document.getElementById(str).remove();
    }
  }

  getActivities() {
    this.eventService.getProvEvents(this.thisId)
    .subscribe(
      data => {
        this.activities = data;
      },
      error => {
        this.model.error = error.error;
      }
    );
  }

  getTickets() {

  }

  getPersonal() {
    this.providerService.getPrivateProvider(this.thisId)
    .subscribe(
      data => {
        this.thisPrivateProvider = data;
        this.model.phone = this.thisPrivateProvider.phone;
        this.model.firstname = this.thisPrivateProvider.firstname;
        this.model.lastname = this.thisPrivateProvider.lastname;
        this.model.bankAccount = this.thisPrivateProvider.bankAccount;
      },
      error => {
        this.model.error = error.error;
      }
    );
  }
  getMonths() {

  }

  updateProvider() {
    if ((this.model.phone !== this.thisPrivateProvider.phone) ||
        (this.model.firstname !== this.thisPrivateProvider.firstname) ||
        (this.model.lastname !== this.thisPrivateProvider.lastname) ||
        (this.model.bankAccount !== this.thisPrivateProvider.bankAccount)) {
      this.providerService.updateProvider(this.thisPrivateProvider.id, this.model.phone,
        this.model.firstname, this.model.lastname, this.model.bankAccount)
        .subscribe(
        data => {
          this.currentUser.phone = this.thisPrivateProvider.phone = this.thisPublicProvider.phone = data.phone;
          this.currentUser.firstname = this.thisPrivateProvider.firstname = this.thisPublicProvider.firstname = data.firstname;
          this.currentUser.lastname = this.thisPrivateProvider.lastname = this.thisPublicProvider.lastname = data.lastname;
          this.currentUser.bankAccount = this.thisPrivateProvider.bankAccount = data.bankAccount;
          this.currentUserService.changeUser(this.currentUser);
        },
        error => {
          //this.alert = true;
          this.model.error = error;
        }
      );
    }
  }
}
