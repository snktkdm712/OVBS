import { TestBed } from '@angular/core/testing';

import { VlocService } from './vloc.service';

describe('VlocService', () => {
  let service: VlocService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VlocService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
