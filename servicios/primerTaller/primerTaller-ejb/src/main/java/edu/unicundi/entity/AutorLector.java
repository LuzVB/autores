/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Valentina
 */
@Entity
@Table(name = "autor_lector")
@NamedQueries({
    @NamedQuery(name = "AutorLector.listarLectorPorAutor", query = "SELECT a FROM AutorLector a Where a.autor.id = :idAutor"),
    @NamedQuery(name = "AutorLector.listarAutorPorLector", query = "SELECT a FROM AutorLector a Where a.lector.id = :idLector"), 
    @NamedQuery(name = "AutorLector.desasociar", query = "Delete FROM AutorLector a Where a.lector.id = :idLector and a.autor.id = :idAutor")  
})
public class AutorLector implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private  AutorLectorPK autorLectorId;
    
    @ManyToOne
    @MapsId("idAutor")
    private Autor autor;

    @ManyToOne
    @MapsId("idLector")    
    private Lector lector;
    
    @Column(name = "info_adicional", length = 25, nullable = true)
    private String infoAdicional;

    public AutorLectorPK getAutorLectorId() {
        return autorLectorId;
    }

    public void setAutorLectorId(AutorLectorPK autorLectorId) {
        this.autorLectorId = autorLectorId;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }        
    
}

