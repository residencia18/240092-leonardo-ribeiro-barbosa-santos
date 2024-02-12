
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicoSubjectService {
  private categoriaSelecionadaSubject = new Subject<string>();

  categoriaSelecionada$ = this.categoriaSelecionadaSubject.asObservable();
  data$: any;

  enviarCategoriaSelecionada(categoria: string) {
    this.categoriaSelecionadaSubject.next(categoria);
  }
}
