import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';
import { Libro } from './../_model/Libro';


@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private url: string = `${environment.HOST}/libros`;
  mensaje = new Subject<string>();
  constructor(private http: HttpClient) { }

  listarPaginado(page:number, size:number) {
    return this.http.get<any>(`${this.url}/listar/page=${page}/size=${size}`);
  }

  guardar(libro:Libro){
    return this.http.post(`${this.url}/guardar`,libro);
  }

  listarPorId(idUsuario:number) {
    return this.http.get<any>(`${this.url}/retornarPorId/${idUsuario}`);
  }

  editar(libro:Libro){
    return this.http.put(`${this.url}/editar`,libro);
  }

  eliminar(idLibro: number){
    return this.http.delete(`${this.url}/eliminar/${idLibro}`);
  }

}
