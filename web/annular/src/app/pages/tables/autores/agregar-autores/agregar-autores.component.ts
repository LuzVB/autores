import { Component, OnInit } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Params, Router } from "@angular/router";
import { Direccion } from "./../../../../_model/Direccion";
import { Autor } from "./../../../../_model/Autor";
import { AutorService } from "./../../../../_services/autor.service";
import { AutoresComponent } from "./../../autores/autores.component";

@Component({
  selector: "app-agregar-autores",
  templateUrl: "./agregar-autores.component.html",
  styleUrls: ["./agregar-autores.component.scss"],
})
export class AgregarAutoresComponent implements OnInit {
  form: FormGroup;
  private id: number;
  private edicion: boolean;
  constructor(
    private autorService: AutorService,
    private autores: AutoresComponent,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = params["id"];
      this.edicion = params["id"] != null;
    });
    this.formulario();
    if (this.edicion == true) {
      this.cargarDatos();
    }
  }
  cargarDatos() {
    this.autorService.listarPorId(this.id).subscribe((data) => {
      this.form.get("nombre").setValue(data.nombre);
      this.form.get("apellido").setValue(data.apellido);
      this.form.get("fecha").setValue(data.fecha);
      this.form.get("barrio").setValue(data.barrio);
      this.form.get("direccion").setValue(data.direccion);
    });
  }

  formulario() {
    this.form = new FormGroup({
      nombre: new FormControl("", [
        Validators.required,
        Validators.maxLength(12),
        Validators.minLength(3),
      ]),
      apellido: new FormControl("", [
        Validators.required,
        Validators.maxLength(30),
        Validators.minLength(5),
      ]),
      fecha: new FormControl("", [Validators.required]),
      barrio: new FormControl("", [
        Validators.required,
        Validators.maxLength(35),
        Validators.minLength(5),
      ]),
      direccion: new FormControl("", [
        Validators.required,
        Validators.maxLength(35),
        Validators.minLength(5),
      ]),
    });
  }

  guardar() {
    let autor = new Autor();
    let direccion = new Direccion();

    direccion.barrio = this.form.value["barrio"];
    direccion.direccion = this.form.value["direccion"];
    autor.nombre = this.form.value["nombre"];
    autor.apellido = this.form.value["apellido"];
    autor.fecha = this.form.value["fecha"] + "T13:33:05.67";
    autor.direccion = direccion;
    autor.estado = true;
    console.log(autor);

    if (this.edicion == true) {
      autor.id = this.id;
      this.autorService.editar(autor).subscribe(() => {
        this.openSnackBar("Autor Editado");
        this.form.reset();
        this.autores.listarPaginado();
        this.router.navigate(["/tables/autores"]);
      });
    } else {
      this.autorService.guardar(autor).subscribe(() => {
        this.openSnackBar("Autor Guardado");
        this.form.reset();
        this.autores.listarPaginado();
        this.router.navigate(["/tables/autores"]);
      });
      this.form.reset();
    }
  }
  openSnackBar(message: string) {
    this.snackBar.open(message, "Información", {
      duration: 3000,
    });
  }
  get nombre() {
    return this.form.get("nombre");
  }
  get apellido() {
    return this.form.get("apellido");
  }
  get fecha() {
    return this.form.get("fecha");
  }
  get barrio() {
    return this.form.get("barrio");
  }

  get direccion() {
    return this.form.get("direccion");
  }
}
