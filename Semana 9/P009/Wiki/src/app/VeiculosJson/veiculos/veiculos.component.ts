import { Component } from '@angular/core';

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent {
  veiculosSelecionados: any[] = [];
  veiculos: any[] = [];
  categorias: string[] = ['Aviões', 'Carros', 'Barcos']; // Adicione mais categorias conforme necessário

  selecionarCategoria(categoria: string) {
    // Limpar a lista de veículos selecionados ao selecionar uma nova categoria
    this.veiculosSelecionados = [];

    // Simular a obtenção de veículos da categoria selecionada (substitua esta lógica com sua própria lógica de obtenção de dados)
    this.veiculos = this.obterVeiculosDaCategoria(categoria);
  }

  obterVeiculosDaCategoria(categoria: string): any[] {
    // Simulando a obtenção de veículos da categoria selecionada com base em algum serviço ou lógica
    // Aqui você pode substituir essa lógica simulada com sua própria lógica para obter os veículos da categoria selecionada
    switch (categoria) {
      case 'Aviões':
        return ['Boeing 747', 'Airbus A380', 'Cessna 172'];
      case 'Carros':
        return ['Toyota Camry', 'Honda Civic', 'Ford Mustang'];
      case 'Barcos':
        return ['Yacht', 'Catamarã', 'Lancha'];
      default:
        return [];
    }
  }
}
