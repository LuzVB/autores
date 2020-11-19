import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Direccion } from './../../../../_model/Direccion';
import { Lector } from './../../../../_model/Lector'
import { LectoresService } from './../../../../_services/lectores.service';
import {LectoresComponent} from './../../lectores/lectores.component';
@Component({
  selector: 'app-agregar-lectores',
  templateUrl: './agregar-lectores.component.html',
  styleUrls: ['./agregar-lectores.component.scss']
})
export class AgregarLectoresComponent implements OnInit {
  form: FormGroup;
  private id: number;
  private edicion: boolean;
  constructor(private lectorService: LectoresService,
              private lector:LectoresComponent,
              private snackBar: MatSnackBar,
              private router: Router,
              private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = params['id'];
      this.edicion = params['id'] != null;

    });
    this.formulario();
    if (this.edicion == true) {
      this.cargarDatos();
    }
  }
  cargarDatos() {
    this.lectorService.listarPorId(this.id).subscribe(data => {
      this.form.get("nombre").setValue(data.nombre);
      this.form.get("apellido").setValue(data.apellido);
    });
  }

  formulario() {
    this.form = new FormGroup({
      'nombre': new FormControl('', [Validators.required, Validators.maxLength(12), Validators.minLength(3)]),
      'apellido': new FormControl('', [Validators.required, Validators.maxLength(30), Validators.minLength(5)])
    }
    );
  }

  guardar() {
    let lector = new Lector();

    lector.nombre = this.form.value['nombre'];
    lector.apellido = this.form.value['apellido'];


    if (this.edicion == true) {
      lector.id = this.id;
      this.lectorService.editar(lector).subscribe(() => {
        this.openSnackBar('Lector Editado');
        this.form.reset();
        this.lector.listarPaginado();
        this.router.navigate(['/tables/lectores']);
      });
    } else {
        
      this.lectorService.guardar(lector).subscribe(() => {
        this.openSnackBar('Lector Guardado');
        this.form.reset();
        this.lector.listarPaginado();
        this.router.navigate(['/tables/lectores']);
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
  get apellido() {
    return this.form.get('apellido');
  }

}
