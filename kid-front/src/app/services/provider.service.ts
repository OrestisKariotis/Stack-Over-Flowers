import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class ProviderService {

  constructor(private http: HttpClient) { }

  getPublicProvider(id: number) {
    return this.http.get<CurrentUser>(`/api/public/${id}`);
  }

  getPrivateProvider(id: number) {
    return this.http.get<CurrentUser>(`/api/private/${id}`);
  }

  updateProvider(id: number, phone: string, firstname: string, lastname: string, bankAccount: string) {
    return this.http.post<ProviderUp>('/api/update/parent', { 'id' : id, 'phone' : phone ,
      'firstname' : firstname, 'lastname' : lastname, 'bankAccount': bankAccount});
  }
}

class ProviderUp {
  id: number;
  firstname: string;
  lastname: string;
  phone: string;
  bankAccount: string;
}
