import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

export class HomeSearch {
  freetext: string;
  enable: boolean;

  constructor(freetext?: string, en?: boolean) {
    this.freetext = freetext || '';
    this.enable = en || false;
  }
}

@Injectable()
export class HomeToSearchService {

  private source = new BehaviorSubject<HomeSearch>(new HomeSearch());
  homesearch = this.source.asObservable();

  constructor() { }

  setSearch(search: HomeSearch) {
    this.source.next(search);
  }

}
