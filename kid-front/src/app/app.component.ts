import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from './services/current-user.service';
import { CurrentUser } from './models/CurrentUser';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  currentUser: CurrentUser;

  constructor (private currentUserService: CurrentUserService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.currentUser = user);
    const prevUser = JSON.parse(sessionStorage.getItem('currentUser')) || {};
    if (prevUser) {
      this.currentUserService.changeUser(new CurrentUser(prevUser));
    }
  }

  logout() {
    this.currentUserService.changeUser(new CurrentUser());
    sessionStorage.clear();
  }

}
