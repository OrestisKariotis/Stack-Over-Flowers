import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class ParentService {

  constructor(private http: HttpClient) { }

  updateParent(id: number, phone: string) {
    return this.http.post<ParentUp>('/api/update/parent', { 'id' : id, 'phone' : phone });
  }

  getCurrTickets(id: number) {
    return this.http.get<any>('/api/list/{id}'); //ticketsmodel kai path
  }
}



class ParentUp {
  id: number;
  phone: string;
}
