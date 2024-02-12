import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { ServicoSubjectService } from '../serviço-subject.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit, OnDestroy {
  dados: string[];
  dadosFiltrados: string[]; // Lista de dados filtrados
  private subscription: Subscription;

  constructor(private servicoSubjectService: ServicoSubjectService) {}

  ngOnInit() {
    this.subscribeToData();
  }

  ngOnDestroy() {
    this.unsubscribeFromData();
  }

  private subscribeToData() {
    this.subscription = this.servicoSubjectService.data$.subscribe(dados => {
      this.dados = dados;
      // Ao receber novos dados, atualize também os dados filtrados
      this.dadosFiltrados = [...this.dados];
    });
  }

  private unsubscribeFromData() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  // Método para filtrar os dados com base no termo de pesquisa
  filtrarDados(termo: string) {
    if (!termo) {
      this.dadosFiltrados = [...this.dados]; // Se o termo de pesquisa estiver vazio, exibir todos os dados
    } else {
      this.dadosFiltrados = this.dados.filter(dado =>
        dado.toLowerCase().includes(termo.toLowerCase())
      );
    }
  }
}
