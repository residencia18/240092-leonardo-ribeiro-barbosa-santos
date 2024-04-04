import { Routes } from '@angular/router';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { TerceiroComponent } from './terceiro/terceiro.component';
import { SegundoComponent } from './segundo/segundo.component';

export const routes: Routes = [];
{
    path: 'primeiro',
    loadComponent: () => import ('./primeiro/primeiro.component').then(comp => comp.PrimeiroComponent)
},
{
    path: 'segundo',
    component: SegundoComponent
},
{
    path: 'terceiro',
    component: TerceiroComponent
}
