import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { PointsPurchaseModel, TicketPurchaseModel, ResultModel } from '../models/PurchaseModel';

@Injectable()
export class PurchaseService {

  constructor(private http: HttpClient) { }

  purchasePoints(pointform: PointsPurchaseModel) {
    return this.http.post<ResultModel>('/api/purchase_points', pointform);
  }

  purchaseTicket(ticketform: TicketPurchaseModel, id: number) {
    return this.http.post<ResultModel>(`/api/purchase_tickets/${id}`, ticketform);
  }
}
