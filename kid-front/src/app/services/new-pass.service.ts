import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class NewPassService {

  constructor(private http: HttpClient) { }

  resetPass(password: string, mode: string, di: string, lsta: string) {
    if (mode === 'parent') {
      return this.http.post<any>('/api/password_change/parent', { 'pseudoPassword': di, 'salt': lsta, 'newPassword': password });
    } else {
      return this.http.post<any>('/api/password_change/provider', { 'pseudoPassword': di, 'salt': lsta, 'newPassword': password });
    }
  }
}
