import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  recordFieldFocus(fieldName: string) {
    throw new Error('Method not implemented.');
  }
  recordFieldValueChange(fieldName: string, value: any) {
    throw new Error('Method not implemented.');
  }
  formData: any = {};

  constructor() { }

  // Método para armazenar os dados do formulário
  storeFormData(data: any) {
    this.formData = { ...this.formData, ...data };
  }

  // Método para obter os dados do formulário
  getFormData() {
    return this.formData;
  }

  // Método para finalizar o armazenamento dos dados no envio do formulário
  finalizeFormData(data: any) {
    this.storeFormData(data);
    // Aqui você pode fazer o que quiser com os dados armazenados, como enviar para um servidor, salvar em um banco de dados, etc.
    console.log('Dados do formulário finalizados:', this.formData);
    // Se desejar, você também pode limpar os dados do formulário após finalizar o envio
    this.clearFormData();
  }

  // Método para limpar os dados do formulário
  clearFormData() {
    this.formData = {};
  }
}
