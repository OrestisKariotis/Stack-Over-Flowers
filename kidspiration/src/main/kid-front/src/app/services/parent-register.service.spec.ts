import { TestBed, inject } from '@angular/core/testing';

import { ParentRegisterService } from './parent-register.service';

describe('ParentRegisterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ParentRegisterService]
    });
  });

  it('should be created', inject([ParentRegisterService], (service: ParentRegisterService) => {
    expect(service).toBeTruthy();
  }));
});
