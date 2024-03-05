import { TestBed } from '@angular/core/testing';

import { FullstackService } from './fullstack.service';

describe('FullstackService', () => {
  let service: FullstackService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FullstackService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
