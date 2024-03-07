import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AutenticacaoComponent } from './autenticacao/autenticacao.component';
import { CadastroSuinoComponent } from './cadastro-suino/cadastro-suino.component';
import { ControlePesoComponent } from './controle-peso/controle-peso.component';
import { ListagemSuinosComponent } from './listagem-suinos/listagem-suinos.component';
import { CadastroPesoComponent } from './cadastro-peso/cadastro-peso.component';
import { EdicaoPesoComponent } from './edicao-peso/edicao-peso.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'autenticacao', component: AutenticacaoComponent },
  { path: 'listagem-suinos', component: ListagemSuinosComponent },
  { path: 'cadastro-suino', component: CadastroSuinoComponent },
  { path: 'controle-peso', component: ControlePesoComponent },
  { path: 'cadastro-peso', component: CadastroPesoComponent},
  { path: 'edicao-peso', component: EdicaoPesoComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
