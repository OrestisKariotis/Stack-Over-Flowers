import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CurrentUserService } from '../services/current-user.service';
import { PurchaseService } from '../services/purchase.service';

import { CurrentUser } from '../models/CurrentUser';
import { TicketPurchaseModel } from '../models/PurchaseModel';

@Component({
  selector: 'app-activity-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {

  model: any = {};
  user: CurrentUser;
  alert: any = {};
  activity = {'event_id': '2',
              'provider_id': '5',
              'businessName': 'Paradise-Kids',
              'title': 'Παιχνιδότοπος - Πάρτυ',
              'date': '2018-03-07',
              'starting_time': '18:00',
              'description': 'Lorem ipsum dolor sit amet,  Maecenas ultricies mi si porta lorem mollis aliquam ut.',
              'categories' : 'Παιχνίδι',
              'ticket_cost' : 500,
              'initial_ticketsNumber' : 20,
              'available_ticketsNumber' : 15,
              'lowestAge' : 5,
              'highestAge' : 10,
              'place' : 'Λεπενιώτου 5, Αθήνα',
              'latitude' : 37.97781,
              'longitude' : 23.721594
              };
  imagepaths = [
    '/assets/eventslideshowtest/1.jpg',
    '/assets/eventslideshowtest/2.jpg'
  ];

  constructor(private purchaseService: PurchaseService, private currentUserService: CurrentUserService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.user = user);
  }

  buyTicket() {
    this.purchaseService.purchaseTicket(new TicketPurchaseModel(this.model)).subscribe(
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
