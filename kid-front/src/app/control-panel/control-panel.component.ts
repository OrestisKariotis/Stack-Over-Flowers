import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-control-panel',
  templateUrl: './control-panel.component.html',
  styleUrls: ['./control-panel.component.css']
})
export class ControlPanelComponent implements OnInit {

  /* This one stays */
  selectmonth = 0;
  months = [
    { 'name': 'Ιανουάριος' , 'num': 0 },
    { 'name': 'Φεβρουάριος' , 'num': 1 },
    { 'name': 'Μάρτιος' , 'num': 2 },
    { 'name': 'Απρίλιος' , 'num': 3 },
    { 'name': 'Μάιος' , 'num': 4 },
    { 'name': 'Ιούνιος' , 'num': 5 },
    { 'name': 'Ιούλιος' , 'num': 6 },
    { 'name': 'Αύγουστος' , 'num': 7 },
    { 'name': 'Σεπτέμβριος' , 'num': 8 },
    { 'name': 'Οκτώβριος' , 'num': 9 },
    { 'name': 'Νοέμβριος' , 'num': 10 },
    { 'name': 'Δεκέμβριος' , 'num': 11 },
    { 'name': 'Συνολικά' , 'num': 12 },
  ];

  /* For testing */
  parents_list = [
    { 'id': 1,
      'username': 'makis45',
      'firstname': 'makis',
      'lastname': 'paparis',
      'email': 'makisp@hotmail.tr',
      'phone': '7485769385',
      'wallet': 4000,
      'spent_points': 2000,
      'ban': false }
  ];
  providers_list = [
    { 'id': 1,
      'username': 'trololo',
      'firstname': 'Tasos',
      'lastname': 'Mitsakis',
      'email': 'mitsakistrololo@gmail.com',
      'phone': '7867690990',
      'businessName': 'LaLa Luna Park',
      'profit': 5000,
      'rights_code': 0 }
  ];
  pending_providers_list = [
    { 'id': 1,
      'username': 'malakia',
      'firstname': 'Nikolakis',
      'lastname': 'Tsoukas',
      'email': 'mamamama@gmail.com',
      'phone': '7867698090',
      'businessName': 'Paixnidia Ouranio Toxo' }
  ];
  pending_events_list = [
    { 'event_id': 1,
      'title': 'Paidiko party',
      'businessName': 'Troloclown',
      'date': '2018-03-20',
      'starting_time': '18:00',
      'description': 'Θα είναι τέλειο πάρτυ, καλή φάση και τα λοιπά μάγκες μου.',
      'categories': 'Παιχνίδι',
      'place': 'Μικράς Αγγλίας 2, Μαρούσι',
      'ticket_cost': 700,
      'lowestAge': 8,
      'highestAge': 12,
      'initial_ticketsNumber': 20 },
    { 'event_id': 2,
      'title': 'Paidiki giorti',
      'businessName': 'Troloclown',
      'date': '2018-03-25',
      'starting_time': '12:00',
      'description': 'Θα είναι τέλειο πάρτυ, καλή φάση και τα λοιπά μάγκες μου.',
      'categories': 'Παιχνίδι',
      'place': 'Μικράς Αγγλίας 2, Μαρούσι',
      'ticket_cost': 700,
      'lowestAge': 5,
      'highestAge': 10,
      'initial_ticketsNumber': 50 }
  ];
  events_list = [
    { 'event_id': 1,
      'title': 'Paidiko party',
      'businessName': 'Troloclown',
      'date': '2018-03-20',
      'starting_time': '18:00',
      'description': 'Θα είναι τέλειο πάρτυ, καλή φάση και τα λοιπά μάγκες μου.',
      'categories': 'Παιχνίδι',
      'place': 'Μικράς Αγγλίας 2, Μαρούσι',
      'ticket_cost': 700,
      'lowestAge': 8,
      'highestAge': 12,
      'initial_ticketsNumber': 20,
      'available_ticketsNumber': 13 }
  ];
  total_stats = [
    { 'numOfParents': 100,
      'numOfProviders': 20,
      'profit': 300 }
  ];
  monthly_stats = [
    { 'month': 0, 'earnings': 100, 'expenses': 30, 'profit': 10 },
    { 'month': 1, 'earnings': 200, 'expenses': 40, 'profit': 18 },
    { 'month': 2, 'earnings': 450, 'expenses': 100, 'profit': 40 },
    { 'month': 3, 'earnings': 700, 'expenses': 270, 'profit': 60 },
    { 'month': 4, 'earnings': 30, 'expenses': 80, 'profit': 3 },
    { 'month': 5, 'earnings': 40, 'expenses': 100, 'profit': 4 },
    { 'month': 6, 'earnings': 600, 'expenses': 20, 'profit': 50 },
    { 'month': 7, 'earnings': 70, 'expenses': 500, 'profit': 7 },
    { 'month': 8, 'earnings': 200, 'expenses': 70, 'profit': 18 },
    { 'month': 9, 'earnings': 30, 'expenses': 100, 'profit': 2 },
    { 'month': 10, 'earnings': 50, 'expenses': 20, 'profit': 5 },
    { 'month': 11, 'earnings': 60, 'expenses': 20, 'profit': 5 },
    { 'month': 12, 'earnings': 2530, 'expenses': 1350, 'profit': 222 }
  ];

  constructor() { }

  ngOnInit() {
  }

  responsive() {
    let x = window.document.getElementById('sidenav');
    if (x.className === 'sidenav') {
        x.className += ' responsive';
    } else {
        x.className = 'sidenav';
    }
}

  adminlogout() { }

  banParent(id: number) { }

  unbanParent(id: number) { }

  resetPassParent(id: number) { }

  suspendProvider(id: number) { }

  banProvider(id: number) { }

  unbanProvider(id: number) { }

  resetPassProvider(id: number) { }

  acceptPendingProvider(id: number) { }

  deletePendingProvider(id: number) { }

  acceptPendingEvent(id: number) { }

  deletePendingEvent(id: number) { }

}
