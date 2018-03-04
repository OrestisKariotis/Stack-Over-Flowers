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
      return this.http.post<CurrentUser>('/api/users', { 'username': username, 'password': password } )
        .map(user => {
          if (user && user.username) {
            user.mode = 'parent';
            user.enable = true;
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    } else {
      return this.http.post<CurrentUser>('/api/users', { 'username': username, 'password': password } )
        .map(user => {
          if (user && user.username) {
            user.mode = 'provider';
            user.enable = true;
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    }
  }
  reset(username: string, mode: string) {
    if (mode === 'parent') {
      return this.http.post<any>('/api/reset/parent', { 'username': username});
    } else {
      return this.http.post<any>('/api/reset/provider', { 'username': username});
    }
  }
}
