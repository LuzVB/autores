import { Component, ViewChild, OnInit } from "@angular/core";
import {
  MatTableDataSource,
  MatPaginator,
  MatSnackBar,
} from "@angular/material";
import { AppSettings } from "../../../app.settings";
import { MatSort } from "@angular/material/sort";
import { Settings } from "../../../app.settings.model";
import { TablesService, Element } from "../tables.service";
import { AutorService } from "./../../../_services/autor.service";
import { ActivatedRoute } from "@angular/router";
import { id } from "@swimlane/ngx-charts/release/utils";
@Component({
  selector: "app-autores",
  templateUrl: "./autores.component.html",
  styleUrls: ["./autores.component.scss"],
})
export class AutoresComponent implements OnInit {
  dataDepartamento: Array<any>;
  ngOnInit() {
    this.listarPaginado();
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  public displayedColumns = [
    "id",
    "nombre",
    "apellido",
    "fecha",
    "barrio",
    "direccion",
    "libros",
    "lectores",
    "acciones",
  ];
  public dataSource: any;
  public settings: Settings;

  cantidad: number;
  pageIndex: number = 0;
  pageSize: number = 2;
  estado: string;
  constructor(
    public appSettings: AppSettings,
    private tablesService: TablesService,
    private autorService: AutorService,
    public route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {}

  listarPaginado() {
    this.autorService
      .listarPaginado(this.pageIndex, this.pageSize)
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data.content);
        // console.log(data.content.estado);
        this.dataSource.sort = this.sort;
        this.cantidad = data.totalElements;
      });
  }

  cambiarPagina(e: any) {
    this.pageIndex = e.pageIndex;
    this.pageSize = e.pageSize;
    this.listarPaginado();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  eliminar(id: number) {
    this.autorService.eliminar(id).subscribe(
      (data) => {
        this.openSnackBar("Autor eliminado correctamente");
        this.listarPaginado();
      },
      (err) => {
        if( err.error.error === 'Transaction marked for rollback.'){
          this.openSnackBar('Desasocie los lectores para eliminar');
        }
        else{
          this.openSnackBar(err.error.error);
        }
      }
    );
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, "Información", {
      duration: 3000,
    });
  }
}
