import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpErrorResponse,
  HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/delay';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/materialize';
import 'rxjs/add/operator/dematerialize';

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {

    constructor() { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        // wrap in delayed observable to simulate server api call
        return Observable.of(null).mergeMap(() => {

            // get users
            if (request.url.endsWith('/api/users') && request.method === 'POST') {
                if (request.body.username !== 'awf') {
                    let body = {
                    id: 1,
                    username: 'lul',
                    firstname: 'awf',
                    lastname: 'agsag',
                    email: 'awf',
                    phone: '1234657890',
                    wallet: 2
                  };
                    return Observable.of(new HttpResponse({ status: 400 , body: body}));
                } else {
                  return Observable.throw('Unauthorised');
                }
            }
          if (request.url.endsWith('/api/provs') && request.method === 'POST') {
                if (request.body.username !== 'awf') {
                    let body = {
                    id: 1,
                    firstname: 'awf',
                    lastname: 'agsag',
                    email: 'awf',
                    phone: 'awf'
                  };
                    return Observable.of(new HttpResponse({ status: 200 , body: body}));
                } else {
                  return Observable.throw('Unauthorised');
                }
            }
          if (request.url.endsWith('/api/purchase/points') && request.method === 'POST') {
                    let body = {
                    id: 1,
                    wallet: 20
                  };
                    return Observable.of(new HttpResponse({ status: 200 , body: body}));
            }
          if (request.url.endsWith('/api/register/event') && request.method === 'POST') {
            return Observable.of(new HttpResponse({ status: 200 }));
          }
          if (request.url.endsWith('/api/register/prder') && request.method === 'POST') {
                if (request.body.username !== 'gazzetta') {
                  let body = {
                    id: 1,
                    name: 'lul',
                    email: 'awf',
                    tel: 'awf',
                    points: 5,
                    enable: true
                  }
                    return Observable.of(new HttpResponse({ status: 400 , body: body}));
                } else if (request.body.firstName === 'lol') {
                    return Observable.throw('Unauthorised');
                } else {
                  return Observable.throw('Error');
                }
            }
            // pass through any requests not handled above
            return next.handle(request);

        })
        .materialize()
        .delay(500)
        .dematerialize();
    }
}

export let fakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: HTTP_INTERCEPTORS,
    useClass: FakeBackendInterceptor,
    multi: true
};
