
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ServicoSubjectService } from '../serviço-subject.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-objetos',
  templateUrl: './objetos.component.html',
  styleUrls: ['./objetos.component.css']
})
export class ObjetosComponent implements OnInit, OnDestroy {
  categoriaSelecionada: string;
  private subscription: Subscription;

  constructor(private servicoSubjectService: ServicoSubjectService) {}

  ngOnInit() {
    this.subscription = this.servicoSubjectService.categoriaSelecionada$.subscribe(categoria => {
      this.categoriaSelecionada = categoria;
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
