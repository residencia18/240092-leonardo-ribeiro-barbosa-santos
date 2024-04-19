import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart, registerables} from 'chart.js'

@Component({
  selector: 'app-controle-peso',
  templateUrl: './controle-peso.component.html',
  styleUrls: ['./controle-peso.component.css']
})
export class ControlePesoComponent implements OnInit {
  constructor() {
    Chart.register(...registerables);
  }
  @ViewChild("meuCanvas", { static: true })
  elemento!: ElementRef;
  
  ngOnInit(){
    
  new Chart(this.elemento.nativeElement,{
    type: 'line',
    data: {
      labels: ["janeiro", "feveireiro", "Março", "Abril", "Maio", "Junho",
       "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
      datasets: [
        {
          data: [10, 15, 92]
        }
      ]
    }
  });  
  }
}
