import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Tarefa } from '../tarefa.model';
import { EmitterService } from '../emitter.service';
import { alterarTarefa } from '../store/tarefa.actions';
import { Store } from '@ngrx/store';
import { TarefaState } from '../store/tarefa.reducer';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-tarefa',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './editar-tarefa.component.html',
  styleUrls: ['./editar-tarefa.component.css'],
})
export class EditarTarefaComponent {
  tarefaModal!: Tarefa;
  descricao: string = '';
  open = false;
  constructor(
    private eventEmitter: EmitterService,
    private store: Store<{ tarefas: TarefaState }>
  ) {}

  ngOnInit() {
    this.eventEmitter.alterarTarefaEvent.subscribe((tarefa: Tarefa) => {
      this.tarefaModal = tarefa;
      this.descricao = this.tarefaModal.descricao;
      console.log('Tarefa antiga', this.tarefaModal);
      this.open = true;
    });
  }

  closeModal() {
    this.open = false;
  }

  setAlterarTarefa() {
    console.log(this.descricao);
    let task: Tarefa = {
      id: this.tarefaModal.id,
      descricao: this.descricao,
    };
    this.store.dispatch(alterarTarefa({ tarefa: task }));
    this.closeModal();
  }
}
