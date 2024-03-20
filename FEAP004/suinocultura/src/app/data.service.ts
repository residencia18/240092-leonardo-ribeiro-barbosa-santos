import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = 'http://localhost:4200/listagem-suinos';


  constructor(private http: HttpClient) { }

  saveData(data: any[]): Observable<any> {
    return this.http.put<any[]>(this.apiUrl, data)
      .pipe(
        catchError(error => {
          throw 'Erro ao salvar os dados: ' + error;
        })
      );
  }
}
