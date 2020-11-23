import { Autor } from './../_model/Autor';

export class Libro {
    id: number;
    nombre: string;
    editorial: string;
    autor:Autor;
}