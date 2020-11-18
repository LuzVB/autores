/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Valentina
 */
@Embeddable
public class AutorLectorPK implements Serializable{
    
   private static final long serialVersionUID = 1L;
   
   @Column(name = "id_autor")
   private Integer idAutor;
   
   @Column(name = "id_lector")
   private Integer idLector;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idAutor);
        hash = 53 * hash + Objects.hashCode(this.idLector);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutorLectorPK other = (AutorLectorPK) obj;
        if (!Objects.equals(this.idAutor, other.idAutor)) {
            return false;
        }
        if (!Objects.equals(this.idLector, other.idLector)) {
            return false;
        }
        return true;
    }
          
}

