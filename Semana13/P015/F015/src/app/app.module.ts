import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroSuinoComponent } from './cadastro-suino/cadastro-suino.component';
import { ListaSuinoComponent } from './lista-suino/lista-suino.component';
import { ControlePesoComponent } from './controle-peso/controle-peso.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroSuinoComponent,
    ListaSuinoComponent,
    ControlePesoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
