import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EventService } from '../services/event.service';

import { SearchModel } from '../models/SearchModel';
import { SearchEventModel } from '../models/EventModel';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  model: any = {};
  events: SearchEventModel[] = [];
  constructor(private eventService: EventService) { }

  ngOnInit() {
  }

  search() {
    if (this.model.cat1) {
      this.model.categories.push('Παραστάσεις');
    }
    if (this.model.cat2) {
      this.model.categories.push('Μουσεία');
    }
    if (this.model.cat3) {
      this.model.categories.push('Αθλητισμός');
    }
    if (this.model.cat4) {
      this.model.categories.push('Παιχνίδι');
    }
    if (this.model.cat5) {
      this.model.categories.push('Επιστήμη&Περιβάλλον');
    }
    if (this.model.cat6) {
      this.model.categories.push('Μαθήματα');
    }
    this.eventService.getSearchEvents(new SearchModel(this.model))
      .subscribe(
        data => {
          this.events = data;
        },
        error => {
          //this.alert = true;
          this.model.error = error.statusText + error.error;
        }
      );
  }

}
