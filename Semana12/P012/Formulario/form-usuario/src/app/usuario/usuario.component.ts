import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { FormService } from '../form.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class FormUsuarioComponent implements OnInit {
  usuarioForm: FormGroup;
  formEnviado: any;

  constructor(private fb: FormBuilder, private formService: FormService, private snackBar: MatSnackBar) {
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

    this.usuarioForm.valueChanges.subscribe((value) => {
      // Lógica para lidar com as mudanças nos valores do formulário
      console.log('Novos valores do formulário:', value);
      this.snackBar.open('Valores do formulário foram alterados!', 'Fechar', { duration: 2000 });
    });

    this.usuarioForm.statusChanges.subscribe((status) => {
      // Lógica para lidar com as mudanças no status do formulário
      console.log('Novo status do formulário:', status);
      if (this.formEnviado) {
        if (status === 'VALID') {
          this.snackBar.open('Formulário válido!', 'Fechar', { duration: 2000 });
        } else {
          this.snackBar.open('Formulário inválido!', 'Fechar', { duration: 2000 });
        }
      }
    });
  }

  onFieldFocus(fieldName: string) {
    // Registro de quando um campo recebe foco
    this.formService.recordFieldFocus(fieldName);
  }

  onFieldValueChange(fieldName: string, value: any) {
    // Registro de quando o valor de um campo é alterado
    this.formService.recordFieldValueChange(fieldName, value);
  }

  // Método customizado para validar espaços no nome do usuário
  noEspacos(control: AbstractControl) { // Aplicando a tipagem AbstractControl
    if (control.value && control.value.trim().length === 0) {
      return { 'noEspacos': true };
    }
    return null;
  }

  senhaValida(control: AbstractControl | null) {
    if (!control || !control.value) return null;

    console.log('Valor do controle:', control.value);

    // Verifica se a senha tem pelo menos 4 caracteres
    if (control.value.length < 4) {
      console.log('Senha tem menos de 4 caracteres');
      return { 'minlength': true };
    }

    // Verifica se a senha inclui pelo menos um caractere e um número
    const senhaRegex = /^(?=.*[a-zA-Z])(?=.*\d)/;

    console.log('Teste de expressão regular:', senhaRegex.test(control.value));
    if (!senhaRegex.test(control.value)) {
      console.log('Senha não atende aos critérios');
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
      // Salvando os dados do formulário no serviço
      this.formService.formData(this.usuarioForm.value);
      console.log('Dados do formulário enviados para o serviço:', this.usuarioForm.value);
      // Limpar o formulário após enviar
      this.usuarioForm.reset();
      this.formEnviado = false;
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
