import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControleSuinoComponent } from './controle-suino.component';

describe('ControleSuinoComponent', () => {
  let component: ControleSuinoComponent;
  let fixture: ComponentFixture<ControleSuinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ControleSuinoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ControleSuinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
