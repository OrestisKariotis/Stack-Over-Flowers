import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { CurrentUser } from '../models/CurrentUser';
import { EventModel } from '../models/EventModel';

@Injectable()
export class AdminService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post<any>('/api/path_known_to_admins/login', { 'username': username, 'password': password } );
  }

  banParent(id: number, ban: boolean) {
    return this.http.post<any>('/api/path_known_to_admins/parents/ban', { 'id': id , 'ban' : ban } );
  }

  banProvider(id: number, code: number) {
    return this.http.post<any>('/api/path_known_to_admins/providers/rights', { 'id': id , 'rights_code' : code } );
  }

  acceptProvider(id: number, des: number) {
    return this.http.post<any>('/api/path_known_to_admins/pending_providers/accept', { 'id': id , 'phone' : des });
  }

  acceptEvent(id: number, des: number) {
    return this.http.post<any>('/api/path_known_to_admins/pending-events/accept', { 'event_id': id , 'highestAge' : des });
  }

  reset(username: string, mode: string) {
    if (mode === 'parent') {
      return this.http.post<any>('/api/reset/parent', { 'username': username});
    } else {
      return this.http.post<any>('/api/reset/provider', { 'username': username});
    }
  }

  getParents() {
    return this.http.get<CurrentUser[]>('/api/path_known_to_admins/parents');
  }

  getProviders() {
    return this.http.get<CurrentUser[]>('/api/path_known_to_admins/providers');
  }

  getPendingProviders() {
    return this.http.get<CurrentUser[]>('/api/path_known_to_admins/pending_providers');
  }

  getActivities() {
    return this.http.get<EventModel[]>('/api/path_known_to_admins/current_events');
  }

  getPendingActivities() {
    return this.http.get<EventModel[]>('/api/path_known_to_admins/pending_events');
  }
}
