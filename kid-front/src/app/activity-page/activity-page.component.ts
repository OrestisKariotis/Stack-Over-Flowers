import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-activity-page',
  templateUrl: './activity-page.component.html',
  styleUrls: ['./activity-page.component.css']
})
export class ActivityPageComponent implements OnInit {

  model: any = {};
  activity = {'event_id': '2',
              'prov_id': '5',
              'prov_name': 'Paradise-Kids',
              'title': 'Παιχνιδότοπος - Πάρτυ',
              'date': '2018-03-07',
              'starting_time': '18:00',
              'description': 'Lorem ipsum dolor sit amet,  Maecenas ultricies mi si porta lorem mollis aliquam ut.',
              'categories' : 'Παιχνίδι',
              'ticketCost' : 500,
              'initTickets' : 20,
              'availTickets' : 15,
              'lowestAge' : 5,
              'highestAge' : 10,
              'address' : 'Λεπενιώτου 5, Αθήνα',
              'latitude' : 37.97781,
              'longitude' : 23.721594
              };

  constructor() { }

  ngOnInit() {
  }

  buyTicket() {
  }

}
