import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class UserLoginService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string , mode: string) {
    if (mode === 'parent') {
      return this.http.post('/api/users', { username: username, password: password } )
        .map(user => {
          if (user) {
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    } else {
      return this.http.post('url to provider login', { username: username, password: password } )
        .map(user => {
          if (user) {
            sessionStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        });
    }
  }
}
