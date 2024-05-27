import { signalStore, withMethods, withState, patchState } from '@ngrx/signals';
import { Tarefa } from '../models/tarefa.model';

type TarefasState = {
    tarefas: Tarefa[];
};

const initialState: TarefasState = {
    tarefas: [
        { id: '1', descricao: 'Estudar Java' },
        { id: '2', descricao: 'Estudar Java Script' },
        { id: '3', descricao: 'Estudar Ruby' },
        { id: '4', descricao: 'Estudar provedor AWS'},
        { id: '5', descricao: 'Ler 1 capitulo do livro no ônibus' },
    ],
};

export const tarefasStore = signalStore(
    { providedIn: 'root' },
    withState(initialState),
    withMethods((store) => ({
        addTarefa(tarefa: Tarefa) {
            const tarefas = store.tarefas();
            patchState(store, { tarefas: [...tarefas, tarefa] });
        },
        removeTarefa(id: string) {
            const tarefas = store.tarefas();
            patchState(store, { tarefas: tarefas.filter(tarefa => tarefa.id !== id) });
        },
        updateTarefa(id: string, descricao: string) {
            const tarefas = store.tarefas();
            patchState(store, {
                tarefas: tarefas.map(tarefa =>
                    tarefa.id === id ? { ...tarefa, descricao } : tarefa
                )
            });
        },
    }))
);
