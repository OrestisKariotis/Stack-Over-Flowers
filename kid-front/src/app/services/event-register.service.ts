import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { EventRegisterModel } from '../models/EventModel';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class EventRegisterService {

  constructor(private http: HttpClient) { }

  register(event: EventRegisterModel, images: FileList) {

    let fd = new FormData();
    fd.append('data', JSON.stringify(event));
    for (let i = 0; i < images.length; i++ ) {
      let im = images[i];
      if (im) {
        fd.append('file', im, im.name);
      }
    }
    return this.http.post<any>('/api/register/even', fd);
  }
}
