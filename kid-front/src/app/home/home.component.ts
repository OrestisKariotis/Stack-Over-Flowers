import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { CurrentUser } from '../models/CurrentUser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'home';
  currentUser: CurrentUser;

  constructor(private currentUserService: CurrentUserService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.currentUser = user);
    const prevUser = JSON.parse(sessionStorage.getItem('currentUser')) || {};
    if (prevUser) {
      this.currentUserService.changeUser(new CurrentUser(prevUser));
    }
  }

}
