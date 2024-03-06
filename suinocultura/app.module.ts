import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CadastroSuinoComponent } from './cadastro-suino/cadastro-suino.component';
import { ControlePesoComponent } from './controle-peso/controle-peso.component';
import { AutenticacaoComponent } from './autenticacao/autenticacao.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';
import { ListagemSuinosComponent } from './listagem-suinos/listagem-suinos.component';
import { CalcularIdadeEmMesesPipe } from './listagem-suinos/calcular-idade-em-meses.pipe';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CadastroSuinoComponent,
    ControlePesoComponent,
    AutenticacaoComponent,
    MenuComponent,
    HomeComponent,
    ListagemSuinosComponent,
    CalcularIdadeEmMesesPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
