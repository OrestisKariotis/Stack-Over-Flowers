import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { PointsPurchaseModel, TicketPurchaseModel, ResultModel } from '../models/PurchaseModel';

@Injectable()
export class PurchaseService {

  constructor(private http: HttpClient) { }

  purchasePoints(pointform: PointsPurchaseModel) {
    return this.http.post<ResultModel>('/api/purchase/points', pointform);
  }

  purchaseTicket(ticketform: TicketPurchaseModel) {
    return this.http.post<ResultModel>('/api/purchase/tickets', ticketform);
  }
}
