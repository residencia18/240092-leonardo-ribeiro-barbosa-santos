import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SesaoComponent } from './sesao/sesao.component';

const routes: Routes = [
  { path: 'sessao-suino', component: SesaoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
