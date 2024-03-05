import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FullstackService {
  private apiUrl = 'http://example.com/api/atendimentos'; // Substitua pela URL correta da sua API

  constructor(private http: HttpClient) {}

  cadastrarAtendimento(atendimento: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, atendimento);
  }
}
