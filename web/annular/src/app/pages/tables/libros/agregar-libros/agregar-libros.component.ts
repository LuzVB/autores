import { Component, Inject, OnInit,ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { LectoresService } from './../../../../_services/lectores.service';
import { LibroService } from './../../../../_services/libro.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AutorLector } from './../../../../_model/AutorLector';
import { Autor} from './../../../../_model/Autor';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Direccion } from './../../../../_model/Direccion';
import { Libro } from './../../../../_model/Libro'
import { LibrosComponent} from './../../libros/libros.component';
@Component({
  selector: 'app-agregar-libros',
  templateUrl: './agregar-libros.component.html',
  styleUrls: ['./agregar-libros.component.scss']
})
export class AgregarLibrosComponent implements OnInit {

  dataAutor:Array<any>;
  idUsuario: number;
  form: FormGroup;
  private id2: number;
  private id: number;
  private edicion: boolean;
  constructor( private libroService:LibroService,
    private lectorService: LectoresService,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute,
    private libro:LibrosComponent) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = params['id'];
      this.edicion = params['id'] != null;

    });
    this.obtenerAutores();
    this.formulario();
    if (this.edicion == true) {
      this.cargarDatos();
    }
  }

  

  obtenerAutores() {
    this.id2 = 0;
    this.lectorService.listarLectorNoAutor(this.id).subscribe(data => {
      this.dataAutor = data;
      console.log(this.dataAutor);
    }
    );
  }

  autorSeleccionado(idUsuario: number){
      this.idUsuario=idUsuario;
  }
  cargarDatos() {
    console.log(this.id+"entre");
    this.libroService.listarPorId(this.id).subscribe(data => {
      console.log(data);
      this.form.get("nombre").setValue(data.nombre);
      this.form.get("editorial").setValue(data.editorial);
      this.form.get("autor").setValue(data.autor.id);
    });
  }

  formulario() {
    this.form = new FormGroup({
      'nombre': new FormControl('', [Validators.required, Validators.maxLength(12), Validators.minLength(3)]),
      'editorial': new FormControl('', [Validators.required, Validators.maxLength(30), Validators.minLength(5)]),
      'autor': new FormControl('', [Validators.required]),
    }
    );
  }

  guardar() {
    let libro = new Libro();
    let autor = new Autor();
    autor.id=this.idUsuario;
    libro.nombre = this.form.value['nombre'];
    libro.editorial = this.form.value['editorial'];
    libro.autor=autor;
    console.log(libro);

    if (this.edicion == true) {
      libro.id = this.id;
      this.libroService.editar(libro).subscribe(() => {
        this.openSnackBar('Lector Editado');
        this.form.reset();
        this.libro.listarPaginado();
        this.router.navigate(['/tables/libros']);
      });
    } else {
      this.libroService.guardar(libro).subscribe(() => {
        this.openSnackBar('Libro Guardado');
        this.form.reset();
        this.libro.listarPaginado();
        this.router.navigate(['/tables/libros']);
      });
      this.form.reset();
    }

  }
  openSnackBar(message: string) {
    this.snackBar.open(message, 'Información', {
      duration: 3000,
    });
  }
  get nombre() {
    return this.form.get('nombre');
  }
  get editorial() {
    return this.form.get('editorial');
  }

  get autor() {
    return this.form.get('autor');
  }
}
