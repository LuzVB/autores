import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';
import { Lector } from './../_model/lector'

@Injectable({
  providedIn: 'root'
})
export class LectoresService {
 
  private url: string = `${environment.HOST}/autores`;
  mensaje = new Subject<string>();
  constructor(private http: HttpClient) { }

  listarPaginado(page:number, size:number) {
    return this.http.get<any>(`${this.url}/listarLector/page=${page}/size=${size}`);
  }

  guardar(lector:Lector){
    return this.http.post(`${this.url}/guardarLector`,lector);
  }

  listarPorId(idUsuario:number) {
    return this.http.get<any>(`${this.url}/listarLectorId/${idUsuario}`);
  }

  editar(lector:Lector){
    return this.http.put(`${this.url}/editarLector`,lector);
  }

}
