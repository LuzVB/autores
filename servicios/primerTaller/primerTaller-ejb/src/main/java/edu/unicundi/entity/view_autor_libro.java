/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author Valentina
 */
@Entity
@Table(name = "view_autor_libro")
@NamedNativeQueries({
//    @NamedNativeQuery(name = "View_autor_datos.listar", query = "SELECT * FROM public.view_autor_datos", resultClass = View_autor_datos.class),
    @NamedNativeQuery(name = "view_autor_libro.listarPagina", query = "SELECT * FROM public.view_autor_libro order by idlibro OFFSET ?pag ROWS FETCH FIRST  ?size ROWS ONLY", resultClass = view_autor_libro.class),
})
public class view_autor_libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlibro;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombrelibro", nullable = false, length = 25)
    private String nombrelibro;
    
    @Column(name = "editorial", nullable = false, length = 15)
    private String editorial;

    public view_autor_libro(Integer id, String nombre, String apellido, Integer idlibro, String nombrelibro, String editorial) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idlibro = idlibro;
        this.nombrelibro = nombrelibro;
        this.editorial = editorial;
    }

    public view_autor_libro() {
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

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
    
    
}
