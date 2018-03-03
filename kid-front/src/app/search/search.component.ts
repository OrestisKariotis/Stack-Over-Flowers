import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EventService } from '../services/event.service';
import { HomeToSearchService, HomeSearch } from '../services/home-to-search.service';
import { NgxPaginationModule } from 'ngx-pagination';

import { SearchModel } from '../models/SearchModel';
import { SearchEventModel } from '../models/EventModel';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  model: any = {};
  homesearch: HomeSearch;
  events: SearchEventModel[] = [];
  constructor(private eventService: EventService, private hometosearchservice: HomeToSearchService) { }

  /* Proswrino gia check */
  activities = [
               {'event_id': '2',
                'title': 'Παιχνιδότοπος - Πάρτυ',
                'date': '2018-03-07',
                'starting_time': '18:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut.',
                'categories' : 'Παιχνίδι',
                'ticket_cost' : 500,
                'latitude' : 37.97781,
                'longitude' : 23.721594
                },
               {'event_id': '3',
                'title': 'Μάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut.',
                'categories' : 'Επιστήμη&Περιβάλλον',
                'ticket_cost' : 1000,
                'latitude' : 38.013583,
                'longitude' : 23.821808
                },
               {'event_id': '5',
                'title': 'Μάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Παραστάσεις',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                },
               {'event_id': '5',
                'title': 'Μάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Παραστάσεις',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                },
               {'event_id': '5',
                'title': 'Μάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Παραστάσεις',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                }
  ];
  imagepaths = [
    '/assets/eventslideshowtest/1.jpg',
    '/assets/eventslideshowtest/2.jpg'
  ];


  ngOnInit() {
    this.hometosearchservice.homesearch.subscribe(search => this.homesearch = search);
    if (this.homesearch.enable) {
      this.eventService.getSearchEvents(new SearchModel(this.homesearch))
      .subscribe(
        data => {
          this.events = data;
        },
        error => {
          //this.alert = true;
          this.model.error = error.statusText + error.error;
        }
      );
      this.homesearch.enable = false;
      this.homesearch.freetext = null;
      this.hometosearchservice.setSearch(this.homesearch);
    }
  }

  search() {
    this.model.categories = [];
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
