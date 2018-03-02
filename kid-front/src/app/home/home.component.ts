import { Component, OnInit } from '@angular/core';
import { SearchEventModel } from '../models/EventModel';
import { EventService } from '../services/event.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  events: SearchEventModel[] = [];

  constructor(private eventService: EventService) { }

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
  }

}
