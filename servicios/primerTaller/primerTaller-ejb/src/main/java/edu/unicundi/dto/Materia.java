/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Valentina
 */
@ApiModel("Modelo Materia")
public class Materia {
    
    @Id
    @ApiModelProperty(value = "id de la materia", required = true)
    private Integer id;
    
    @NotNull
    @ApiModelProperty(value = "nombre de la materia", required = true)
    private String nombre;
    
    @NotNull
    @ApiModelProperty(value = "cupo de la materia", required = true)
    private Integer cupo;
    
    @NotNull
    @ApiModelProperty(value = "credito de la materia", required = true)
    private Integer credito;

    public Materia(){
    }
    
    public Materia(Integer id,String nombre,Integer cupo, Integer credito){
        this.id = id;
        this.nombre = nombre;
        this.cupo = cupo;
        this.credito = credito;
    }
    
    @ApiModelProperty(value = "Mostrar id de la materia")
    public Integer getId() {
        return id;
    }
   
    @ApiModelProperty(value = "Modificar id de la materia")
    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "Mostrar nombre de la materia")
    public String getNombre() {
        return nombre;
    }

    @ApiModelProperty(value = "Modificar id de la materia")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ApiModelProperty(value = "Mostrar cupos de la materia")
    public Integer getCupo() {
        return cupo;
    }

    @ApiModelProperty(value = "Modificar cupo de la materia")
    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    @ApiModelProperty(value = "Mostrar crditos de la materia")
    public Integer getCredito() {
        return credito;
    }

    @ApiModelProperty(value = "Modificar credito de la materia")
    public void setCredito(Integer credito) {
        this.credito = credito;
    }
    
  
}

