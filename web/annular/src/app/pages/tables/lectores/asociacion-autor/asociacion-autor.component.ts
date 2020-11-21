import { Component, Inject, OnInit,ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { LectoresService } from './../../../../_services/lectores.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AutorLector } from './../../../../_model/AutorLector';
import { Autor} from './../../../../_model/Autor';
import { Lector } from './../../../../_model/Lector';

@Component({
  selector: 'app-asociacion-autor',
  templateUrl: './asociacion-autor.component.html',
  styleUrls: ['./asociacion-autor.component.scss']
})
export class AsociacionAutorComponent implements OnInit {

  id: number;
  idUsuario: number;
  dataAutor:Array<any>;
  selectedValue : string;;
  displayedColumns: string[] = ['nombre','acciones'];
  dataSource = new MatTableDataSource<any>();
 
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private snackBar: MatSnackBar,
              private lectorService: LectoresService,
              public dialogRef: MatDialogRef<AsociacionAutorComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.listarLectorAutor();
    this.obtenerAutores();
  }

  eliminar() {
    this.dialogRef.close({event: 'Elimino', data: '123'});
  }

  cerrarDialogo(){
    this.dialogRef.close({event: 'Cancelo'});
  }  

  listarLectorAutor(){
    this.id = this.data.id;
    console.log(this.id);
    this.lectorService.listarAutorLector(this.id).subscribe(data=>{
      console.log(data);
      this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    });
  }

  obtenerAutores() {
    this.id = this.data.id;
    this.lectorService.listarLectorNoAutor(this.id).subscribe(data => {
      this.dataAutor = data;
    }
    );
  }

  autorSeleccionado(idUsuario: number){
      this.idUsuario=idUsuario;
  }

  asociarLector(){
    if(this.idUsuario == null){
      this.openSnackBar('Seleccione Autor');
    }else{
      let lector = new Lector();
      lector.id=this.id;
      let autor = new Autor();
      autor.id=this.idUsuario;
      let autorlector = new AutorLector();
      autorlector.autor=autor;
      autorlector.lector=lector;
      autorlector.infoAdicional="Libro"+this.id+this.idUsuario;
      console.log(autorlector);
     this.lectorService.asociarLector(autorlector).subscribe(() => {
      this.openSnackBar('Autor Asociado');
      this.listarLectorAutor();
      this.obtenerAutores();
    });
  }
}

desaSociarLector(idUsuario:number){
    let lector = new Lector();
      lector.id=this.id;
      let autor = new Autor();
      autor.id=idUsuario;
      let autorlector = new AutorLector();
      autorlector.autor=autor;
      autorlector.lector=lector;
      console.log(autorlector);
      this.lectorService.desaSociarLector(autorlector).subscribe(() => {
      this.openSnackBar('Autor Desasociado');
      this.listarLectorAutor();
      this.obtenerAutores();
    });
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Información', {
      duration: 3000,
    });
  }

}
