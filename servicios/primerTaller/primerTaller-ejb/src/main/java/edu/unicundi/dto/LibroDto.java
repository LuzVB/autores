/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import java.io.Serializable;

/**
 *
 * @author Valentina
 */
public class LibroDto implements Serializable {
    
    private Integer id;

    private String nombre;
    
    private String editorial;
    
    private AutorP autor;

    public LibroDto() {
    
    }
    
    public LibroDto(Integer id, String nombre, String editorial, AutorP autor) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public AutorP getAutor() {
        return autor;
    }

    public void setAutor(AutorP autor) {
        this.autor = autor;
    }
    
    
    
}
