import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';

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

}
