  import { Component } from '@angular/core';
  import { CommonModule } from '@angular/common';
  import { RouterOutlet } from '@angular/router';
  import { Store, createFeatureSelector } from '@ngrx/store';
  import { TarefaState, tarefasReducer } from './store/tarefa.reducer';
  import { Observable } from 'rxjs';
  import { InputTarefaComponent } from './input-tarefa/input-tarefa.component';
  import { ShowTarefasComponent } from './show-tarefas/show-tarefas.component';
  import { EditarTarefaComponent } from './editar-tarefa/editar-tarefa.component';
  import { tarefasStore } from './store/tarefa.store';
  import { Tarefa } from './models/tarefa.model'
  import { selectorSelecionaTarefa } from './store/tarefa.seletors';
  


  @Component({
    selector: 'app-root',
    standalone: true,
    imports: [
      CommonModule,
      RouterOutlet,
      InputTarefaComponent,
      ShowTarefasComponent,
      EditarTarefaComponent,
    
    ],
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
   
  })
  export class AppComponent {
    title = 'NgRxV2';
    tarefas$: Observable<TarefaState>;
    tarefasStore: any;
    tarefas: Tarefa[] = [];
    emitterService: any;
    selectTarefaFeature = createFeatureSelector<TarefaState>('tarefas');

    constructor(private store: Store<{ tarefas: TarefaState }>) {
      this.tarefas$ = this.store.select(selectorSelecionaTarefa);
    }

    ngOnInit() {
      this.tarefasStore.state$.subscribe((state: TarefaState) => {
        this.tarefas = state.tarefas;
      });
    }

    addTarefa(tarefa: Tarefa) {
      this.tarefasStore.addTarefa(tarefa);
    }
   
  
    alterarTarefa(tarefa: Tarefa) {
      this.emitterService.alterarTarefaEvent.emit(tarefa);
      console.log('Alterar tarefa', tarefa);
    }
  }




