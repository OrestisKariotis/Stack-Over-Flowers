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
    return this.http.post<ParentUp>('/api/update/parent', { 'id' : id, 'phone' : phone });
  }

  getCurrTickets(id: number) {
    return this.http.get<TicketsModel[]>(`/api/list/${id}`);
  }

  getOldTickets(id: number) {
    return this.http.get<TicketsModel[]>(`/api/old/${id}`);
  }

  getChanges(id: number, wallet: number) {
    let param = new HttpParams();
    param = param.append('wallet', wallet.toString());
    return this.http.get<any>(`api/profile/${id}`, { params: param});
  }
}

class ParentUp {
  id: number;
  phone: string;
}
