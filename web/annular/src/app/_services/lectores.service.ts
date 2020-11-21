import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';
import { Lector } from './../_model/lector';
import { AutorLector } from './../_model/AutorLector';

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

  listarAutorLector(id :number){
    return this.http.get<any>(`${this.url}/listarAutor/${id}`);
  }

  listarLectorNoAutor(id :number){
    console.log(id)
    return this.http.get<any>(`${this.url}/listarAutorNo/${id}`);
  }

  asociarLector(lector:AutorLector){
    return this.http.post(`${this.url}/asociarLector/`,lector);
  }

  desaSociarLector(lector:AutorLector){
    return this.http.post(`${this.url}/desasociarLector/`,lector);
  }

}
