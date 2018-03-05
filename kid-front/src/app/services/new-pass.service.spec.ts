import { TestBed, inject } from '@angular/core/testing';

import { NewPassService } from './new-pass.service';

describe('NewPassService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NewPassService]
    });
  });

  it('should be created', inject([NewPassService], (service: NewPassService) => {
    expect(service).toBeTruthy();
  }));
});
