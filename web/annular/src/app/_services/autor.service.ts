import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';
import { Autor } from './../_model/Autor'
@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private url: string = `${environment.HOST}/autores`;
  mensaje = new Subject<string>();
  constructor(private http: HttpClient) { }

  listarPaginado(page:number, size:number) {
    return this.http.get<any>(`${this.url}/listarGeneral/page=${page}/size=${size}`);
  }
  guardar(autor:Autor){
    return this.http.post(`${this.url}/guardar`,autor);
  }

  listarPorId(idUsuario:number) {
    return this.http.get<any>(`${this.url}/listarGeneralId/${idUsuario}`);
  }

  editar(autor:Autor){
    return this.http.put(`${this.url}/editar`,autor);
  }


}
