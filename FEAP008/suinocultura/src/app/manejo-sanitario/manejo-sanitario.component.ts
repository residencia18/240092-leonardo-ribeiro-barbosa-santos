import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-manejo-sanitario',
  templateUrl: './manejo-sanitario.component.html',
  styleUrls: ['./manejo-sanitario.component.css']
})
export class ManejoSanitarioComponent {
  formulario: FormGroup;
  sessoes: any[] = []; // Array para armazenar as sessões cadastradas
  manejoSanitarioService: any;
  formularioEnviado = false; // Flag para rastrear se o formulário foi enviado

  constructor(private formBuilder: FormBuilder) {
    this.formulario = this.formBuilder.group({
      data: ['', Validators.required],
      brincoAnimal: ['', Validators.required],
      vacinaRaiva: ['', Validators.required],
      vacinaRinite: ['', Validators.required]
    });
  }

  cadastrarSessao() {
    this.formularioEnviado = true; // Marca o formulário como enviado

    if (this.formulario.valid) {
      const novaSessao = this.formulario.value;
      this.sessoes.push(novaSessao); // Adiciona a nova sessão ao array de sessões
      this.formulario.reset(); // Limpa o formulário após o cadastro
      this.formularioEnviado = false; // Reseta o estado do formulário enviado
    } else {
      // Exiba uma mensagem de erro para o usuário
    }
  }

  // Método para obter os controles do formulário no template
  get controles() {
    return this.formulario.controls;
  }
}





