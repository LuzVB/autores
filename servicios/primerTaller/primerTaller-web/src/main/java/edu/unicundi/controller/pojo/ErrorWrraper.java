/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.controller.pojo;



import java.time.LocalTime;
import java.util.Date;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Valentina
 */
@ApiModel("Modelo ErrorWrraper")
public class ErrorWrraper implements Serializable {
    
    @Id
    @ApiModelProperty(value = "tipo de error HTTP", required = true)
    private String error;
    
    @NotNull
    @ApiModelProperty(value = "codigo de respuesta HTTP", required = true)
    private int codigo;
    
    @NotNull
    @ApiModelProperty(value = "nombre del codigo de respuest HTTP", required = true)
    private String nombreCodigo;
    
    
    @ApiModelProperty(value = "hora local de la respuesta", required = true)
    private LocalTime hora ;
    
    @ApiModelProperty(value = "fecha de la respueta", required = true)
    private String fecha;

    public ErrorWrraper(String error, int codigo, String nombreCodigo) {
        Date fechaAhora = new Date(System.currentTimeMillis());
        this.error = error;
        this.codigo = codigo;
        this.nombreCodigo = nombreCodigo;
        this.hora = LocalTime.now();
        this.fecha = fechaAhora.toString();
    }

   
    @ApiModelProperty(value = "Mostrar el tipo de error HTTP")
    public String getError() {
        return error;
    }

    @ApiModelProperty(value = "Modificar el tipo de error HTTP")
    public void setError(String error) {
        this.error = error;
    }

    @ApiModelProperty(value = "Mostrar el codigo de respuesta HTTP")
    public int getCodigo() {
        return codigo;
    }

    @ApiModelProperty(value = "Modificar el codigo de respuesta HTTP")
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @ApiModelProperty(value = "Mostrar el nombre del codigo de respuest HTTP")
    public String getNombreCodigo() {
        return nombreCodigo;
    }

    @ApiModelProperty(value = "Modificar el nombre del codigo de respuest HTTP")
    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    @ApiModelProperty(value = "Mostrar la hora local de la respuesta")
    public LocalTime getHora() {
        return hora;
    }

     @ApiModelProperty(value = "Modificar la hora local de la respuesta")
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @ApiModelProperty(value = "Mostrar la fecha de la respueta")
    public String getFecha() {
        return fecha;
    }

    @ApiModelProperty(value = "Modificar la fecha de la respueta")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
   
}
