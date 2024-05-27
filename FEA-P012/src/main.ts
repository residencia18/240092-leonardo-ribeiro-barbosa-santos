import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideStore } from '@ngrx/store';
import { tarefasReducer } from './app/store/tarefa.reducer';

bootstrapApplication(AppComponent, {
  providers: [
    provideStore({ tarefas: tarefasReducer }), // Configuração do StoreModule
  ],
}).catch((err) => console.error(err));
