import { Component } from '@angular/core';
import { WikipediaService } from './wikipedia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  searchResults: any[] = [];
  searchTerm: string = '';
  title = "Wiki";
  noResultsMessage: string = '';
  selectedTab: string = 'wiki'; // Inicialmente selecionado o Wiki
  showViagensContent: boolean = false; // Define se o conteúdo de Viagens deve ser exibido
  showVeiculosContent: boolean = false; // Define se o conteúdo de Veiculos deve ser exibido

  constructor(private wikipediaService: WikipediaService) {}

  // Método para alternar entre as abas
  selectTab(tab: string) {
    this.selectedTab = tab;
    if (tab === 'wiki') {
      // Se o Wiki for selecionado, limpe os resultados da pesquisa e esconda os conteúdos de Viagens e Veiculos
      this.searchResults = [];
      this.showViagensContent = false;
      this.showVeiculosContent = false;
    } else if (tab === 'viagens') {
      // Se Viagens for selecionado, mostre o conteúdo de Viagens e esconda Veiculos
      this.showViagensContent = true;
      this.showVeiculosContent = false;
    } else if (tab === 'veiculos') {
      // Se Veiculos for selecionado, mostre o conteúdo de Veiculos e esconda Viagens
      this.showViagensContent = false;
      this.showVeiculosContent = true;
    }
  }

  // Método para executar a pesquisa
  onSearch() {
    if (this.searchTerm.trim() !== '') {
      this.wikipediaService.search(this.searchTerm).subscribe((data) => {
        this.searchResults = data.query.search;
        this.noResultsMessage = this.searchResults.length === 0 ? `Nenhum resultado encontrado para "${this.searchTerm}"` : '';
      });
    } else {
      // Limpar resultados se o termo de busca estiver vazio
      this.searchResults = [];
      this.noResultsMessage = '';
    }
  }
}
