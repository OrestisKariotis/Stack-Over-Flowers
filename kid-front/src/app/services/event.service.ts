import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { EventModel, PendingEventModel, HistoryEventModel, ProviderViewEventModel,
  SearchEventModel, EventRegisterModel } from '../models/EventModel';
import { SearchModel } from '../models/SearchModel';

@Injectable()
export class EventService {

  constructor(private http: HttpClient) { }

  //selida event
  getFullEvent(event_id: number) {
    return this.http.get<EventModel>(`/api/events/${event_id}`);
  }

  //selida search
  getSearchEvents(filters: SearchModel) {
    return this.http.post<SearchEventModel[]>('/api/search', filters);
  }

  //selida home
  getHomeEvents() {
    return this.http.get<SearchEventModel[]>('/api/home/events');
  }

  //selida admin, pending tab
  getAdminPendingEvents() {
    return this.http.get<EventModel[]>('/api/pendingEvents');
  }

  //selida admin, current tab
  getAdminEvents() {
    return this.http.get<EventModel[]>('/api/events');
  }

  //selida provider profile, tab2, tab5
  getProvEvents(provider_id: number) {
    return this.http.get<ProviderViewEventModel[]>(`/api/provider/${provider_id}/events`);
  }

  //selida provider profile, tab4
  getProvPendingEvents(provider_id: number) {
    return this.http.get<PendingEventModel[]>(`/api/provider/${provider_id}/pendingEvents`);
  }

  //selida provider profile, tab4
  getProvHistoryEvents(provider_id: number) {
    return this.http.get<HistoryEventModel[]>(`/api/provider/${provider_id}/historyEvents`);
  }
}
