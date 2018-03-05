import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { CurrentUser } from '../models/CurrentUser';
import { AdminService } from '../services/admin.service';
import { Router } from '@angular/router';
import { EventModel } from '../models/EventModel';

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
  parents_list: CurrentUser[];
  providers_list: CurrentUser[];
  pending_providers_list: CurrentUser[];
  pending_events_list: EventModel[];
  events_list: EventModel[];
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

  constructor(private router: Router, private currentUserService: CurrentUserService, private adminService: AdminService) { }

  ngOnInit() {
    this.getParents();
  }

  responsive() {
    let x = window.document.getElementById('sidenav');
    if (x.className === 'sidenav') {
        x.className += ' responsive';
    } else {
        x.className = 'sidenav';
    }
}

  adminlogout() {
    this.currentUserService.changeUser(new CurrentUser());
    sessionStorage.clear();
  }

  banParent(id: number) {
    this.adminService.banParent(id, true).subscribe(
      data => {
        const ind = this.parents_list.findIndex(function(elem) { return elem.id === id; } );
        this.parents_list[ind].ban = true;
      }
    );
  }

  unbanParent(id: number) {
    this.adminService.banParent(id, false).subscribe(
      data => {
        const ind = this.parents_list.findIndex(function(elem) { return elem.id === id; } );
        this.parents_list[ind].ban = false;
      }
    );
  }

  resetPassParent(username: string) {
    this.adminService.reset(username, 'parent').subscribe(
      data => {
      }
    );
  }

  suspendProvider(id: number) {
    this.adminService.banProvider(id, 1).subscribe(
      data => {
        const ind = this.providers_list.findIndex(function(elem) { return elem.id === id; } );
        this.providers_list[ind].rights_code = 1;
      }
    );
  }

  banProvider(id: number) {
    this.adminService.banProvider(id, 2).subscribe(
      data => {
        const ind = this.providers_list.findIndex(function(elem) { return elem.id === id; } );
        this.providers_list[ind].rights_code = 2;
      }
    );
  }

  unbanProvider(id: number) {
    this.adminService.banProvider(id, 0).subscribe(
      data => {
        const ind = this.providers_list.findIndex(function(elem) { return elem.id === id; } );
        this.providers_list[ind].rights_code = 0;
      }
    );
  }

  resetPassProvider(username: string) {
    this.adminService.reset(username, 'provider').subscribe(
      data => {
      }
    );
  }

  acceptPendingProvider(id: number) {
    this.adminService.acceptProvider(id, 1).subscribe(
      data => {
        const ind = this.pending_providers_list.findIndex(function(elem) { return elem.id === id; } );
        this.pending_providers_list.splice(ind, 1);
      }
    );
  }

  deletePendingProvider(id: number) {
    this.adminService.acceptProvider(id, 0).subscribe(
      data => {
        const ind = this.pending_providers_list.findIndex(function(elem) { return elem.id === id; } );
        this.pending_providers_list.splice(ind, 1);
      }
    );
  }

  acceptPendingEvent(id: number) {
    this.adminService.acceptEvent(id, 1).subscribe(
      data => {
        const ind = this.pending_events_list.findIndex(function(elem) { return elem.event_id === id; } );
        this.pending_events_list.splice(ind, 1);
      }
    );
  }

  deletePendingEvent(id: number) {
    this.adminService.acceptEvent(id, 0).subscribe(
      data => {
        const ind = this.pending_events_list.findIndex(function(elem) { return elem.event_id === id; } );
        this.pending_events_list.splice(ind, 1);
      }
    );
  }

  getParents() {
    this.adminService.getParents().subscribe(
      data => {
        this.parents_list = data;
      }
    );
  }

  getProviders() {
    this.adminService.getProviders().subscribe(
      data => {
        this.providers_list = data;
      }
    );
  }

  getPendingProviders() {
    this.adminService.getPendingProviders().subscribe(
      data => {
        this.pending_providers_list = data;
      }
    );
  }

  getActivities() {
    this.adminService.getActivities().subscribe(
      data => {
        this.events_list = data;
      }
    );
  }

  getPendingActivities() {
    this.adminService.getPendingActivities().subscribe(
      data => {
        this.pending_events_list = data;
      }
    );
  }
}
