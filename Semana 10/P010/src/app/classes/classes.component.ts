// classes.component.ts
import { Component } from '@angular/core';
import { ServicoSubjectService } from '../serviço-subject.service';

@Component({
  selector: 'app-classes',
  templateUrl: './classes.component.html',
  styleUrls: ['./classes.component.css']
})
export class ClassesComponent {
  constructor(private servicoSubjectService: ServicoSubjectService) {}

  selecionarCategoria(categoria: string) {
    this.servicoSubjectService.enviarCategoriaSelecionada(categoria);
  }
}
