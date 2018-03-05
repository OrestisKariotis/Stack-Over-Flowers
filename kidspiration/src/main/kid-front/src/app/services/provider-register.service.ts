import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { ProviderRegisterModel } from '../models/ProviderRegisterModel';
import { CurrentUser } from '../models/CurrentUser';
@Injectable()
export class ProviderRegisterService {

  constructor(private http: HttpClient) { }

  register(provider: ProviderRegisterModel, logo: File, authdocs: File) {

    let fd = new FormData();
    fd.append('data', JSON.stringify(provider));
    fd.append('logo', logo);
    fd.append('file', authdocs);
    return this.http.post<CurrentUser>('/api/register/provider', fd);
  }

  registerFiles(provider: ProviderRegisterModel, logo: File, authdocs: File) {
    let fd = new FormData();
    fd.append('username', provider.username);
    fd.append('logo', logo);
    fd.append('file', authdocs);
    return this.http.post<CurrentUser>('/api/register/provider/files', fd);
  }

  registerJson(provider: ProviderRegisterModel) {
    return this.http.post<CurrentUser>('/api/register/provider', provider);
  }
}
