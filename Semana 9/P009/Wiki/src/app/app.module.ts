import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchResultsComponent } from './components/search-results/search-results.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { HighlightPipe } from './highlight.pipe';
import { HttpClientModule } from '@angular/common/http';  // Adicionado HttpClientModule
import { FormsModule } from '@angular/forms';
import { WikipediaService } from './wikipedia.service';
import { SiteUESCComponent } from './Uesc-site/site-uesc/site-uesc.component';
import { VeiculosComponent } from './VeiculosJson/veiculos/veiculos.component';
import { ViagensComponent } from './Turismo/viagens/viagens.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchResultsComponent,
    SearchBarComponent,
    HighlightPipe,
    SiteUESCComponent,
    VeiculosComponent,
    ViagensComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,  // Adicionado HttpClientModule
  ],
  providers: [WikipediaService],  // Não é necessário incluir o HttpClient nos providers
  bootstrap: [AppComponent]
})
export class AppModule { }
