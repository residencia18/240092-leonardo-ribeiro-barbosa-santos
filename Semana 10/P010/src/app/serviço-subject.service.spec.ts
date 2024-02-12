import { TestBed } from '@angular/core/testing';

import { ServicoSubjectService } from './serviço-subject.service';

describe('ServiçoSubjectService', () => {
  let service: ServicoSubjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicoSubjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
