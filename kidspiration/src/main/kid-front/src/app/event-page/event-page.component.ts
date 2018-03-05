import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { CurrentUserService } from '../services/current-user.service';
import { PurchaseService } from '../services/purchase.service';
import { EventService } from '../services/event.service';

import { CurrentUser } from '../models/CurrentUser';
import { TicketPurchaseModel } from '../models/PurchaseModel';
import { EventModel } from '../models/EventModel';

@Component({
  selector: 'app-activity-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {

  model: any = {};
  thisId: number;
  user: CurrentUser;
  alert: any = {};
  activity: EventModel;
  imagepaths = [
    '/assets/eventslideshowtest/1.jpg',
    '/assets/eventslideshowtest/2.jpg'
  ];
  //EIKONES

  constructor(private purchaseService: PurchaseService, private currentUserService: CurrentUserService, private route: ActivatedRoute,
    private eventService: EventService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.user = user);
    this.thisId = +this.route.snapshot.paramMap.get('id');
    this.eventService.getFullEvent(this.thisId)
    .subscribe(
      data => {
        this.activity = data;
      },
      error => {
        this.model.error = error.error;
      }
    );
  }

  buyTicket() {
	this.model.id = this.user.id;
    this.purchaseService.purchaseTicket(new TicketPurchaseModel(this.model), this.thisId).subscribe(
        data => {
          this.user.wallet = data.wallet;
          this.currentUserService.changeUser(this.user);
          this.alert.head = 'ΕΠΙΤΥΧΙΑ';
          this.alert.body = 'Τα εισιτήρια αγοράστηκαν επιτυχώς! Θα σας αποσταλεί mail με τα στοιχεία τους.';
        },
        error => {
          this.alert.head = 'Αποτυχία';
          this.alert.error = error.error;
        }
      );
    window.document.getElementById('openModalButton').click();
  }

}
