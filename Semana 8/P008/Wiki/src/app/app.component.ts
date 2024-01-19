// app.component.ts
import { Component } from '@angular/core';
import { WikipediaService } from './wikipedia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  searchResults: any[] = [];
  searchTerm: string ='';

  constructor(private wikipediaService: WikipediaService) {}

  onSearch(term: string) {
    this.searchTerm = term;
    
    if (term.trim() !== '') {
      this.wikipediaService.search(term).subscribe((data) => {
        this.searchResults = data.query.search;
      });
    } else {
      // Limpar resultados se o termo de busca estiver vazio
      this.searchResults = [];
    }
  }
}
