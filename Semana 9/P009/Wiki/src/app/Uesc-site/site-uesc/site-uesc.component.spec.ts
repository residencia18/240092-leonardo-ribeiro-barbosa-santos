import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteUESCComponent } from './site-uesc.component';

describe('SiteUESCComponent', () => {
  let component: SiteUESCComponent;
  let fixture: ComponentFixture<SiteUESCComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SiteUESCComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SiteUESCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
