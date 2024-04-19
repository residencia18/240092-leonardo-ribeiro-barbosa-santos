import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CadastroSuinoComponent } from './cadastro-suino/cadastro-suino.component';
import { ControlePesoComponent } from './controle-peso/controle-peso.component';
import { ListagemSuinosComponent } from './listagem-suinos/listagem-suinos.component';
import { AutenticacaoComponent } from './autenticacao/autenticacao.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { CalcularIdadeEmMesesPipe } from './calcular-idade-em-meses.pipe';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ManejoSanitarioComponent } from './manejo-sanitario/manejo-sanitario.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [

    HeaderComponent,
    FooterComponent,
    CadastroSuinoComponent,
    ControlePesoComponent,
    ListagemSuinosComponent,
    AutenticacaoComponent,
    MenuComponent,
    HomeComponent,
    CalcularIdadeEmMesesPipe,
    ManejoSanitarioComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
