import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SearchEventModel } from '../models/EventModel';

import { EventService } from '../services/event.service';
import { HomeToSearchService, HomeSearch } from '../services/home-to-search.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  events: SearchEventModel[] = [];
  homesearch: HomeSearch;

  constructor(private eventService: EventService, private homesearchservice: HomeToSearchService, private router: Router) { }

  ngOnInit() {
    /*this.eventService.getHomeEvents().subscribe(
        data => {
          this.events = data;
        },
        error => {
          this.alert = true;
          this.model.error = error;
        }
      );*/
    this.homesearchservice.homesearch.subscribe(search => this.homesearch = search);
  }

  goSearch(text: string) {
    this.homesearch.freetext = text;
    this.homesearch.enable = true;
    this.router.navigate(['/search']);
  }
}
