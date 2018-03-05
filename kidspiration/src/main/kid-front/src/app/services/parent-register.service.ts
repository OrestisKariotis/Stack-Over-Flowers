import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { ParentRegisterModel } from '../models/ParentRegisterModel';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class ParentRegisterService {

  constructor(private http: HttpClient) { }

  register(parent: ParentRegisterModel) {
      return this.http.post<CurrentUser>('/api/register/parent', parent).map(user => {
        if (user && user.username) {
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
      });
  }
}
