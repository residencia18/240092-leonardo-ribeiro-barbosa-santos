import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FullstackService } from '../fullstack.service';

@Component({
  selector: 'app-cadastro-atendimento',
  templateUrl: './cadastro-atendimento.component.html',
  styleUrls: ['./cadastro-atendimento.component.css']
})
export class CadastroAtendimentoComponent {
  formularioAtendimento: FormGroup;
  novoAtendimento: any = {}; // Adicione a definição da propriedade novoAtendimento aqui

  constructor(private formBuilder: FormBuilder, private atendimentoService: FullstackService) {
    this.formularioAtendimento = this.formBuilder.group({
      petName: ['', Validators.required],
      ownerName: ['', Validators.required],
      date: ['', Validators.required]
    });
  }

  submitForm() {
    if (this.formularioAtendimento.valid) {
      this.novoAtendimento = this.formularioAtendimento.value; // Atribua o valor do formulário à propriedade novoAtendimento
      this.atendimentoService.cadastrarAtendimento(this.novoAtendimento)
        .subscribe((response) => {
          console.log('Atendimento cadastrado com sucesso:', response);
          this.formularioAtendimento.reset();
        }, (error) => {
          console.error('Erro ao cadastrar atendimento:', error);
        });
    } else {
      // Trate o caso em que o formulário não é válido
    }
  }
}
