import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUser } from '../models/CurrentUser';
import { EventRegisterModel } from '../models/EventModel';

import { EventRegisterService } from '../services/event-register.service';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-event-register',
  templateUrl: './event-register.component.html',
  styleUrls: ['./event-register.component.css']
})
export class EventRegisterComponent implements OnInit {

  model: any = {};
  done: boolean = false;
  alert: boolean = false;
  images: FileList = null;
  user: CurrentUser;

  constructor(private currentUserService: CurrentUserService, private eventRegisterService: EventRegisterService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.user = user);
    this.model.provider_id = this.user.id;
  }

  eventRegister() {
    this.alert = false;
    this.done = false;
    if (!this.images) {
      this.alert = true;
      this.model.error = 'select some images';
    } else if (!this.model.provider_id) {
      this.alert = true;
      this.model.error = 'reload page';
    } else {
      this.alert = false;
      this.eventRegisterService.register(new EventRegisterModel(this.model), this.user.id)
      .subscribe(
        data => {
          this.done = true;
        },
        error => {
          this.alert = true;
          this.model.error = error.error;
        }
      );
    }
  }

  imagesChange(images: any) {
    this.images = images;
  }
}
