import { createReducer, on } from "@ngrx/store";
import { Tarefa } from "../tarefa.model";
import { adicionarTarefa, removerTarefa, editarTarefa } from "./tarefa.actions";

export interface TarefaState {
    tarefas: Tarefa[];
}

export const estadoInicial: TarefaState = {
    tarefas: [
    { id: '1', descricao: 'Estudar Java' },
    { id: '2', descricao: 'Estudar Java Script' },
    { id: '3', descricao: 'Estudar Ruby' },
    { id: '4', descricao: 'Estudar provedor AWS'},
    { id: '5', descricao: 'Ler 1 capitulo do livro no ônibus' },]
};

export const tarefasReducer = createReducer(
    estadoInicial,
    on(adicionarTarefa, (estado, action) => ({ ...estado, tarefas: [...estado.tarefas, action.tarefa] })),
    on(removerTarefa, (estado, action) => ({ ...estado, tarefas: estado.tarefas.filter(t => t.id !== action.id) })),
    on(editarTarefa, (estado, action) => ({
        ...estado,
        tarefas: estado.tarefas.map(tarefa =>
            tarefa.id === action.id ? { ...tarefa, descricao: action.descricao } : tarefa
        )
    }))
);
