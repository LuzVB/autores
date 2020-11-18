import { Component, ViewChild,OnInit } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { AppSettings } from '../../../app.settings';
import { MatSort } from '@angular/material/sort';
import { Settings } from '../../../app.settings.model';
import { TablesService, Element } from '../tables.service';
import { AutorService } from './../../../_services/autor.service';
@Component({
  selector: 'app-autores',
  templateUrl: './autores.component.html',
  styleUrls: ['./autores.component.scss']
})
export class AutoresComponent implements OnInit {

  dataDepartamento: Array<any>
  ngOnInit() {
    this.listarPaginado();
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  public displayedColumns = ['id','nombre', 'apellido', 'fecha','barrio','direccion','libros', 'estado'];
  public dataSource: any;
  public settings: Settings;

  cantidad: number;
  pageIndex:number =0;
  pageSize: number =2;
  estado:string;
  constructor(public appSettings:AppSettings, private tablesService:TablesService,private autorService: AutorService) {
  }
  

  listarPaginado() {
    this.autorService.listarPaginado(this.pageIndex, this.pageSize).subscribe(
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
}
