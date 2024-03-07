  import { Component, OnInit } from '@angular/core';
  import { Suino } from '../suino.model';
  import { CalcularIdadeEmMesesPipe } from '../calcular-idade-em-meses.pipe';
  import { FormBuilder, FormGroup } from '@angular/forms';
  import { DataService } from '../data.service';


  @Component({
    selector: 'app-listagem-suinos',
    templateUrl: './listagem-suinos.component.html',
    styleUrls: ['./listagem-suinos.component.css'],
    providers: [CalcularIdadeEmMesesPipe]
  })
  export class ListagemSuinosComponent {
    selectedSexo: string = '';
    categories: string[] = ['M', 'F'];
    filteredSuinos: Suino[] = [];
    suinoSalvo: boolean = false;
    
    suinos: any[] = [
      { 
        brincoPai: '123', 
        brincoMae: '456', 
        dataNascimento: new Date('2023-01-15'), 
        dataSaida: new Date('2024-02-28'), 
        sexo: 'M', 
        status: 'ativo' 
      },
      { 
        brincoPai: '789', 
        brincoMae: '012', 
        dataNascimento: new Date('2023-05-20'), 
        dataSaida: new Date('2024-03-01'), 
        sexo: 'F', 
        status: 'vendido' 
      }
    ]
    suinoForm: FormGroup;
    suinoEdit: Suino | null = null;
    editando: boolean = false;
    suinoFormVisible: boolean = false;


    constructor(private formBuilder: FormBuilder, private dataService: DataService) {
      this.suinoForm = this.formBuilder.group({
        brincoPai: [''],
        brincoMae: [''],
        dataNascimento: [''],
        dataSaida: [''],
        sexo: [''],
        status: ['']
      });
    }


    
    filterSuinos(): void {
      console.log("Sexo selecionado:", this.selectedSexo);
      if (this.selectedSexo) {
        this.filteredSuinos = this.suinos.filter(suino => suino.sexo === this.selectedSexo);
      } else {
        this.filteredSuinos = [];
      }
    }
    

    

  

      editarSuino(suino: Suino): void {
        this.suinoEdit = suino;
        this.suinoForm.patchValue(suino);
        this.editando = true;
      }

      atualizarSuino(): void {
        const suinoAtualizado: Suino = this.suinoForm.value;
        const indiceSuino = this.suinos.findIndex(suino => suino.brincoPai === suinoAtualizado.brincoPai);
        if (indiceSuino !== -1) {
          this.suinos[indiceSuino] = suinoAtualizado;
          console.log('Suíno atualizado:', suinoAtualizado);
      
          this.dataService.saveData(this.suinos).subscribe(() => {
            console.log('Dados salvos com sucesso!');
            this.suinoSalvo = true; // Exibe a mensagem de sucesso
            setTimeout(() => {
              this.suinoSalvo = false; // Após alguns segundos, oculta a mensagem de sucesso
            }, 3000); // Tempo em milissegundos (3 segundos)
          }, error => {
            console.error('Erro ao salvar os dados:', error.message); // Alteração feita aqui
          });
        }
        this.editando = false; // Encerra o modo de edição
        this.suinoForm.reset(); // Reseta o formulário
      }
      
    
      suinoSelecionado: Suino | null = null;
      selecionarSuino(suino: Suino): void {
        this.suinoSelecionado = suino;
      }

      excluirSuinoSelecionado(): void {
     
    
      }

  }
