/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Luz
 */
@Entity
@Table(name = "Curso")
@NamedQueries({
    @NamedQuery(name = "Curso.listarTodo", query = "SELECT c FROM Curso c")
})
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Descripcion requerida")
    @Size(max = 25)
    @Column(name = "descripcion", length = 25, nullable = false)
    private String descripcion;

    @NotNull(message = "Aula requerida")
    @Size(max = 25)
    @Column(name = "aula", length = 25, nullable = false)
    private String aula;

//    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Estudiante> estudiante;

    public Curso() {
    }

//    public Curso(Integer id, String descripcion, String aula, List<Estudiante> estudiante) {
//        this.id = id;
//        this.descripcion = descripcion;
//        this.aula = aula;
//        this.estudiante = estudiante;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

//    public List<Estudiante> getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(List<Estudiante> estudiante) {
//        this.estudiante = estudiante;
//    }

}
