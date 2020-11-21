import { Component, ViewChild,OnInit } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { AppSettings } from '../../../app.settings';
import { MatSort } from '@angular/material/sort';
import { Settings } from '../../../app.settings.model';
import { TablesService, Element } from '../tables.service';
import { LectoresService } from './../../../_services/lectores.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import {AsociacionAutorComponent} from './asociacion-autor/asociacion-autor.component';
import {Lector} from './../../../_model/Lector';
@Component({
  selector: 'app-lectores',
  templateUrl: './lectores.component.html',
  styleUrls: ['./lectores.component.scss']
})
export class LectoresComponent implements OnInit {
  ngOnInit() {
    this.listarPaginado();
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  public displayedColumns = ['id','nombre', 'apellido','acciones'];
  public dataSource: any;
  public settings: Settings;

  cantidad: number;
  pageIndex:number =0;
  pageSize: number =2;
  estado:string;
  constructor(public appSettings:AppSettings, private tablesService:TablesService,private lectorService: LectoresService,
              public route: ActivatedRoute,
              public dialog: MatDialog,) {
  }

  listarPaginado() {
    this.lectorService.listarPaginado(this.pageIndex, this.pageSize).subscribe(
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

  abrirDialogo(lector: Lector) {

    const dialogRef = this.dialog.open(AsociacionAutorComponent, {
      width: '400px',
      data: { nombre: lector.nombre, id: lector.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result != null) {
          if(result.event === 'Elimino') {
            console.log('Elimino');
            console.log(result.data);
          } else if (result.event === 'Cancelo') { 
            console.log('Cancelo');
          }
      }
    });
    
  }
}
