import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesaoComponent } from './sesao.component';

describe('SesaoComponent', () => {
  let component: SesaoComponent;
  let fixture: ComponentFixture<SesaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SesaoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SesaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
