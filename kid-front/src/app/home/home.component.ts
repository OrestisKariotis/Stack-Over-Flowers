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

  /* Proswrino gia check */
  lat_add_ev = [
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
                'title': 'Φάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Παραστάσεις',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                },
               {'event_id': '10',
                'title': 'Τρολολό',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Παραστάσεις',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                },
               {'event_id': '12',
                'title': 'Μπιπ μπιπ',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Αθλητισμός',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                },
               {'event_id': '20',
                'title': 'Μάπα',
                'date': '2018-03-10',
                'starting_time': '20:00',
                'description': 'Lorem ipsum dolor sit amet, Maecenas ultricies mi si porta lorem mollis aliquam ut abcdefghijklmnopq',
                'categories' : 'Μουσεία',
                'ticket_cost' : 1000,
                'latitude' : 38.02381,
                'longitude' : 23.848450
                }
  ];

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
