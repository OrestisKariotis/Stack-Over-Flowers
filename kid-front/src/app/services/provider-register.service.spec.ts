import { TestBed, inject } from '@angular/core/testing';

import { ProviderRegisterService } from './provider-register.service';

describe('ProviderRegisterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProviderRegisterService]
    });
  });

  it('should be created', inject([ProviderRegisterService], (service: ProviderRegisterService) => {
    expect(service).toBeTruthy();
  }));
});
