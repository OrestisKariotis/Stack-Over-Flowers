import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { CurrentUser } from '../models/CurrentUser';
import { ResultModel, TicketsModel } from '../models/PurchaseModel';

@Injectable()
export class ParentService {

  constructor(private http: HttpClient) { }

  updateParent(id: number, phone: string) {
    return this.http.post<ParentUp>('/api/profile/parent/${id}/personal_info/edit', { 'id' : id, 'phone' : phone });
  }

  getCurrTickets(id: number) {
    return this.http.get<TicketsModel[]>(`/api/profile/parent/${id}/tickets`);
  }

  getOldTickets(id: number) {
    return this.http.get<TicketsModel[]>(`/api/profile/parent/${id}/old_tickets`);
  }

  getChanges(id: number, wallet: number) {
    let param = new HttpParams();
    param = param.append('wallet', wallet.toString());
    return this.http.get<any>(`/api/profile/parent/${id}/personal_info`, { params: param});
  }
}

class ParentUp {
  id: number;
  phone: string;
}
