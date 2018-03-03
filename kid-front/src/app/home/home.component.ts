import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { CurrentUser } from '../models/CurrentUser';
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
  title = 'home';
  currentUser: CurrentUser;
  events: SearchEventModel[] = [];
  homesearch: HomeSearch;

  constructor(private currentUserService: CurrentUserService, private eventService: EventService,
    private homesearchservice: HomeToSearchService, private router: Router) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.currentUser = user);
    this.homesearchservice.homesearch.subscribe(search => this.homesearch = search);
    this.eventService.getHomeEvents().subscribe(
      data => {
        this.events = data;
      },
      error => {
        /*this.alert = true;
        this.model.error = error;*/
      }
    );
  }

  goSearch(text: string) {
    if (text) {
      this.homesearch.freetext = text;
      this.homesearch.enable = true;
      this.homesearchservice.setSearch(this.homesearch);
    }
    this.router.navigate(['/search']);
  }
}
