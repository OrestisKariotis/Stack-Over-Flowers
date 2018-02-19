import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
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
                if (true) {
                    let body = {
                    id: 1,
                    name: 'awf',
                    email: 'awf',
                    tel: 'awf',
                    points: 2,
                    enable: true
                  };
                    return Observable.of(new HttpResponse({ status: 200, body: body }));
                } else {
                  return Observable.throw('Unauthorised');
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
