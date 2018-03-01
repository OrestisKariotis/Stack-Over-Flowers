import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class UserLoginService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string , mode: string) {
    if (mode === 'parent') {
      return this.http.post<CurrentUser>('/api/users', { username: username, password: password } )
        .map(user => {
          if (user && user.id) {
            user.mode = 'parent';
            user.enable = true;
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    } else {
      return this.http.post<CurrentUser>('/api/provs', { username: username, password: password } )
        .map(user => {
          if (user && user.id) {
            user.mode = 'provider';
            user.enable = true;
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    }
  }
}
