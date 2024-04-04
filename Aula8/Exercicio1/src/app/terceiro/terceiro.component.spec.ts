import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerceiroComponent } from './terceiro.component';

describe('TerceiroComponent', () => {
  let component: TerceiroComponent;
  let fixture: ComponentFixture<TerceiroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TerceiroComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TerceiroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
