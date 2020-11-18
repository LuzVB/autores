/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Valentina
 */
@Entity
@Table(name = "autor")
@NamedQueries({
    @NamedQuery(name = "Autor.listarTodo", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.validarAutor", query = "SELECT COUNT(a.id) FROM Autor a WHERE a.id = :id"),
    @NamedQuery(name = "Autor.listarSoloAutor", query = "SELECT a.id, a.nombre, a.apellido, a.fecha FROM Autor a"),
    @NamedQuery(name = "Autor.estado", query = "Update Autor u set u.estado = :estado WHERE u.id = :id"),
//    @NamedQuery(name = "Autor.listarLibros", query = "@PUT")
})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Autor.listarTodoConsultaNativo", query = "select a.id, a.nombre, a.apellido, a.fecha from public.autor a", resultClass = Autor.class),
    @NamedNativeQuery(name = "Autor.listarPagina", query = "SELECT * FROM autor order by id OFFSET ?pag ROWS FETCH FIRST  ?size ROWS ONLY", resultClass = Autor.class),
    @NamedNativeQuery(name = "Autor.cantidadAutores", query = "select count(id)from autor")
})
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Libro> libro;

    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Direccion direccion;

    public Autor() {
    
    }
   
    public Autor(Integer id, String nombre, String apellido, Boolean estado, Date fecha, List<Libro> libro, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.fecha = fecha;
        this.libro = libro;
        this.direccion = direccion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
//    @JsonIgnore
    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }  

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
