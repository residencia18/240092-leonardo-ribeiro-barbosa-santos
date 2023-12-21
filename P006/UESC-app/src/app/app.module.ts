import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { DestaqueComponent } from './components/destaque/destaque.component';
import { ServicosComponent } from './components/servicos/servicos.component';
import { ResultadosComponent } from './components/resultados/resultados.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    NoticiasComponent,
    DestaqueComponent,
    ServicosComponent,
    ResultadosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
