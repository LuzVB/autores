import { Component, ViewChild,OnInit } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSnackBar } from '@angular/material';
import { AppSettings } from '../../../app.settings';
import { MatSort } from '@angular/material/sort';
import { Settings } from '../../../app.settings.model';
import { TablesService, Element } from '../tables.service';
import { LibroService } from './../../../_services/libro.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})
export class LibrosComponent implements OnInit {
  dataDepartamento: Array<any>
  ngOnInit() {
    this.listarPaginado();
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  public displayedColumns = ['id','libro', 'editorial', 'autor','acciones'];
  public dataSource: any;
  public settings: Settings;

  cantidad: number;
  pageIndex:number =0;
  pageSize: number =2;
  estado:string;
  constructor(public appSettings:AppSettings, private tablesService:TablesService,private libroService: LibroService,
              public route: ActivatedRoute,  private snackBar: MatSnackBar) {
  }
  

  listarPaginado() {
    this.libroService.listarPaginado(this.pageIndex, this.pageSize).subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data.content);
        console.log(data.content.estado);
        this.dataSource.sort = this.sort;
        this.cantidad = data.totalElements;
      }
    );
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
    this.libroService.eliminar(id).subscribe(
      (data) => {
        this.openSnackBar("Libro eliminado correctamente");
        this.listarPaginado();
      },
      (err) => {
        console.log(err.error.error);
        this.openSnackBar(err.error.error);
      }
    );
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, "Información", {
      duration: 3000,
    });
  }

}
