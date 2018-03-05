import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class CurrentUserService {

  private source = new BehaviorSubject<CurrentUser>(new CurrentUser());
  currentUser = this.source.asObservable();

  constructor() { }

  changeUser(user: CurrentUser) {
    this.source.next(user);
  }
}
