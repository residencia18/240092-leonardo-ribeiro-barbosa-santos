import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class FormUsuarioComponent implements OnInit {
  usuarioForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.usuarioForm = {} as FormGroup;
   }

  ngOnInit(): void {
    this.usuarioForm = this.fb.group({
      nomeUsuario: ['', [Validators.required, Validators.maxLength(12), this.noEspacos]],
      senha: ['', [Validators.required, Validators.minLength(4), this.senhaValida]],
      email: ['', [Validators.required, Validators.email]],
      nomeCompleto: ['', Validators.required],
      telefone: ['', [Validators.required, this.telefoneValido]],
      endereco: ['', Validators.required],
      dataNascimento: ['', [Validators.required, this.dataNascimentoValida]],
      genero: ['', Validators.required],
      profissao: ['', Validators.required]
    });
  }

  // Método customizado para validar espaços no nome do usuário
  noEspacos(control: AbstractControl) { // Aplicando a tipagem AbstractControl
    if (control.value && control.value.trim().length === 0) {
      return { 'noEspacos': true };
    }
    return null;
  }

  // Método customizado para validar a senha
  senhaValida(control: AbstractControl | null) {
    if (!control || !control.value) return null;

    const senhaRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{4,}$/;
    if (!senhaRegex.test(control.value)) {
      return { 'senhaInvalida': true };
    }
    return null;
  }

  telefoneValido(control: AbstractControl | null) {
    if (!control || !control.value) return null;

    const telefoneRegex = /^[0-9]{10,11}$/;
    if (!telefoneRegex.test(control.value)) {
      return { 'telefoneInvalido': true };
    }
    return null;
  }

  dataNascimentoValida(control: AbstractControl | null) {
    if (!control || !control.value) return null;

    const dataNascimento = new Date(control.value);
    const idadeMinima = 18;
    const hoje = new Date();
    const diffAnos = hoje.getFullYear() - dataNascimento.getFullYear();
    if (diffAnos < idadeMinima || isNaN(diffAnos)) {
      return { 'dataNascimentoInvalida': true };
    }
    return null;
  }

  onSubmit() {
    if (this.usuarioForm.valid) {
      console.log(this.usuarioForm.value); // Aqui você pode fazer o que quiser com os dados do formulário
    } else {
      // Marque os campos como tocados para exibir mensagens de erro
      this.marcarCamposTocados(this.usuarioForm);
    }
  }

  marcarCamposTocados(formGroup: FormGroup) {
    Object.values(formGroup.controls).forEach(control => {
      if (control instanceof FormGroup) {
        this.marcarCamposTocados(control);
      } else {
        control.markAsTouched();
      }
    });
  }
}