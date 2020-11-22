/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Valentina
 */
@Entity
@Table(name = "view_autor_datos")
@NamedNativeQueries({
    @NamedNativeQuery(name = "View_autor_datos.listar", query = "SELECT * FROM public.view_autor_datos", resultClass = View_autor_datos.class),
    @NamedNativeQuery(name = "View_autor_datos.listarPagina", query = "SELECT * FROM public.view_autor_datos order by id OFFSET ?pag ROWS FETCH FIRST  ?size ROWS ONLY", resultClass = View_autor_datos.class),
})
public class View_autor_datos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "direccion", nullable = false, length = 70)
    private String direccion;
    
    @Column(name = "barrio", nullable = false, length = 25)
    private String barrio;
    
    @Column(name = "libros", nullable = false, length = 25)
    private int  libros ;
    
    @Column(name = "lector", nullable = false, length = 25)
    private int  lector ;

    public View_autor_datos() {
    }

    public View_autor_datos(Integer id, String nombre, String apellido, Boolean estado, Date fecha, String direccion, String barrio, int libros, int lector) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.fecha = fecha;
        this.direccion = direccion;
        this.barrio = barrio;
        this.libros = libros;
        this.lector = lector;
    }

    public int getLector() {
        return lector;
    }

    public void setLector(int lector) {
        this.lector = lector;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getLibros() {
        return libros;
    }

    public void setLibros(int libros) {
        this.libros = libros;
    }


    
}
