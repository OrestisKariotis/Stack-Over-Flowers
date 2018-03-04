import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';

import { CurrentUserService } from './current-user.service';
import { CurrentUser } from '../models/CurrentUser';

@Injectable()
export class ParentProfGuardService implements CanActivate {

  user: CurrentUser;
  constructor(private router: Router, private service: CurrentUserService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    this.service.currentUser.subscribe(user => this.user = user);
    const id = route.params.id;
    if (this.user.mode === 'parent' && this.user.id === Number(id)) {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }
}

@Injectable()
export class PointsGuardService implements CanActivate {

  user: CurrentUser;
  constructor(private router: Router, private service: CurrentUserService) {}

  canActivate() {
    this.service.currentUser.subscribe(user => this.user = user);
    if (this.user.mode === 'parent') {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }
}

@Injectable()
export class EventRegGuardService implements CanActivate {

  user: CurrentUser;
  constructor(private router: Router, private service: CurrentUserService) {}

  canActivate() {
    this.service.currentUser.subscribe(user => this.user = user);
    if (this.user.mode === 'provider') {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }
}
