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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Valentina
 */
@Entity
@Table(name = "lector")
@NamedNativeQueries({
    @NamedNativeQuery(name = "Lector.listarTodo", query = "SELECT * FROM lector order by id OFFSET ?pag ROWS FETCH FIRST  ?size ROWS ONLY", resultClass = Lector.class),
    @NamedNativeQuery(name = "Lector.cantidadLectores", query = "select count(id)from lector")
})
public class Lector implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Nombre requerido")
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @NotNull(message = "Apellido requerido")
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    

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
        
}

