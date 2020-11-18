import { Libro } from './../_model/Libro';
import { Direccion } from './../_model/Direccion';

export class Conductor {
    id: number;
    nombre: string;
    apellido: string;
    estado: Boolean;
    fecha: string;
    direccion: Direccion;
    libro:Libro;
}