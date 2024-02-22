
import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.css']
})
 
  export class Componente1Component implements OnInit {
  
    Componente1Form!: FormGroup;
    nomeDoConsumidor!: string;
  
    inscricao1!: Subscription;
    inscricao2!: Subscription;
    inscricao3!: Subscription;
    inscricao4!: Subscription;
    inscricao5!: Subscription;
    inscricao6!: Subscription;
  
    constructor(private formBuilder: FormBuilder){
      
    }
  
    ngOnInit() {
      this.Componente1Form = this.formBuilder.group({
        nomeCliente: ['', [Validators.required, Validators.minLength(5)] ],
        tipoServico: ['', Validators.required],
        dataOrdem: ['', Validators.required],
        detalhes: ['']
      });
    }
  
    onSubmit(){
      console.log(this.Componente1Form?.value);
    }	
  
    inscricaoValueChanges(){
      console.log('Inscrição valueChanges');
      let inscricao1 = this.Componente1Form.get('nomeCliente')?.valueChanges.subscribe(
        valor => console.log('Nome do cliente: ' + valor)
      );
      let inscricao2 = this.Componente1Form.get('tipoServico')?.valueChanges.subscribe(
        valor => console.log('Tipo de serviço: ' + valor)
      );
      let inscricao3 = this.Componente1Form.get('dataOrdem')?.valueChanges.subscribe(
        valor => console.log('Data da ordem: ' + valor)
      );
      let inscricao4 = this.Componente1Form.get('detalhes')?.valueChanges.subscribe(
        valor => console.log('Detalhes: ' + valor)
      );
    }
  
    inscricaoStatusChanges(){
      console.log('Inscrição statusChanges');
      let inscricao5 = this.Componente1Form.get('nomeCliente')?.statusChanges.subscribe(
        status => console.log('Status do nome do cliente: ' + status)
      );
      let inscricao6 = this.Componente1Form.get('tipoServico')?.statusChanges.subscribe(
        status => console.log('Status do tipo de serviço: ' + status)
      );
    }
  
    onNomeDoConsumidorChange(){
      console.log('Nome do consumidor foi trocado: ' + this.nomeDoConsumidor);
    }
  
    ngOnDestroy(){
      this.inscricao1.unsubscribe();
      this.inscricao2.unsubscribe();
      this.inscricao3.unsubscribe();
      this.inscricao4.unsubscribe();
      this.inscricao5.unsubscribe();
      this.inscricao6.unsubscribe();
      
    }
  
  
  }
  
