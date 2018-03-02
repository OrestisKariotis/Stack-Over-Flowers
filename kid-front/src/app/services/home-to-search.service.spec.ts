import { TestBed, inject } from '@angular/core/testing';

import { HomeToSearchService } from './home-to-search.service';

describe('HomeToSearchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HomeToSearchService]
    });
  });

  it('should be created', inject([HomeToSearchService], (service: HomeToSearchService) => {
    expect(service).toBeTruthy();
  }));
});
