import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'calcularIdadeEmMeses'
})
export class CalcularIdadeEmMesesPipe implements PipeTransform {
  transform(dataNascimento: Date): string {
    const hoje = new Date();
    const diffAnos = hoje.getFullYear() - dataNascimento.getFullYear();
    const diffMeses = diffAnos * 12 + hoje.getMonth() - dataNascimento.getMonth();
    return diffMeses + ' meses';
  }
}
