import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { CurrentUser } from '../models/CurrentUser';
import { TotalModel, PendingEventModel, HistoryEventModel } from '../models/EventModel';

@Injectable()
export class ProviderService {

  constructor(private http: HttpClient) { }

  getPublicProvider(id: number) {
    return this.http.get<CurrentUser>(`/api/profile/provider/${id}/info`);
  }

  getPrivateProvider(id: number) {
    return this.http.get<CurrentUser>(`/api/profile/provider/${id}/personal_info/`);
  }

  updateProvider(id: number, phone: string, firstname: string, lastname: string, bankAccount: string) {
    return this.http.post<ProviderUp>(`/api/profile/provider/${id}/personal_info/`, { 'id' : id, 'phone' : phone ,
      'firstname' : firstname, 'lastname' : lastname, 'bankAccount': bankAccount});
  }

  getMonth(id: number, month: number) {
    return this.http.get<any>(`/api/profile/provider/${id}/months_report/${month}`);
  }

  getTotal(id: number, month: number) {
    return this.http.get<TotalModel[]>(`/api/profile/provider/${id}/total_report/${month}`);
  }

}

class ProviderUp {
  id: number;
  firstname: string;
  lastname: string;
  phone: string;
  bankAccount: string;
}
