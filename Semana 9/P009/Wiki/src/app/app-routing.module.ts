import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViagensComponent } from './Turismo/viagens/viagens.component';

const routes: Routes = [ { path: 'viagens', component: ViagensComponent } ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
