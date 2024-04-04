import { Routes } from '@angular/router';


export const routes: Routes = [
{
    path: 'primeiro',
    loadComponent: () => import ('./primeiro/primeiro.component').then(comp => comp.PrimeiroComponent)
},
{
    path: 'segundo',
    loadComponent: () => import ('./segundo/segundo.component').then(comp => comp.SegundoComponent)
},
{
    path: 'terceiro',
    loadComponent: () => import ('./terceiro/terceiro.component').then(comp => comp.TerceiroComponent)
}
];