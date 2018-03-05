import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { EventRegisterModel } from '../models/EventModel';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class EventRegisterService {

  constructor(private http: HttpClient) { }

  register(event: EventRegisterModel, id: number) {
    return this.http.post<any>(`/api/upload_event/${id}`, event);
  }
}
