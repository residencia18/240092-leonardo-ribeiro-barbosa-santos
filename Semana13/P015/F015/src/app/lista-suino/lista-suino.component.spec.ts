import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaSuinoComponent } from './lista-suino.component';

describe('ListaSuinoComponent', () => {
  let component: ListaSuinoComponent;
  let fixture: ComponentFixture<ListaSuinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListaSuinoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaSuinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
