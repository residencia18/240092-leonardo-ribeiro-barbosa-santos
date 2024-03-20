import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoSanitarioComponent } from './manejo-sanitario.component';

describe('ManejoSanitarioComponent', () => {
  let component: ManejoSanitarioComponent;
  let fixture: ComponentFixture<ManejoSanitarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManejoSanitarioComponent]
    });
    fixture = TestBed.createComponent(ManejoSanitarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should submit form with valid data', () => {
    const formData = {
      data: '2024-03-20',
      descricao: 'Descrição da sessão',
      animais: '10, 12, 15',
      atividades: 'Vacinação contra raiva'
    };

    // Atribua os dados do formulário ao componente
    component.formulario.setValue(formData);

    // Simule o envio do formulário
    component.cadastrarSessao();

    // Verifique se o método cadastrarSessao foi chamado com os dados corretos
    expect(component.manejoSanitarioService.cadastrarSessao).toHaveBeenCalledWith(formData);
  });
});

