/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Valentina
 */
public class ProfesorA  implements Serializable {

    /**
     * id que identifica al profesor
     */
    @Id
    @NotNull(message="El id no puede ser null")
    private int id;
    /**
     * nombre del profesor
     */
    
    @NotNull(message="El nombre no puede ser null")
    private String nombre;
    /**
     * apellido del profesor
     */
    @NotNull(message="El apellido no puede ser null")
    private String apellido;
    /**
     * listado de las materias que imparte
     */
    @NotNull(message = "Campo requerido")
    private List<String> listaMateria;
    /**
     * correo personal del profesor
     */
    @NotNull(message="El correo no puede ser null")
    private String correo;
    /**
     * cedula del profesor
     */
    @NotNull(message="La cedula no puede ser null")
    @Size(max = 10, min=3)
    private String cedula;

    /**
     * metodo para obtener el id del profesor
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * metodo para setear la valiable id
     *
     * @param id variable para guardar el id del profesor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * metodo para obtener el nombre del profesor
     *
     * @return String
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * metodo para setear el nombre
     *
     * @param nombre variable para guardar el nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metod para obtener el apellido del profesor
     *
     * @return String
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * metodo para setear el valor del apellido
     *
     * @param apellido variable para guardar el apellido del profesor
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * metodo para obtener el listado de materias
     *
     * @return List
     */

    public List<String> getListaMateria() {
        return listaMateria;
    }

    /**
     * metodo para setear la lista de materias
     *
     * @param listaMateria variable para guardar la lista de materias que dicta del profesor
     */
    public void setListaMateria(List<String> listaMateria) {
        this.listaMateria = listaMateria;
    }

    /**
     * metodo para obtener el correo del profesor
     *
     * @return String 
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * metodo para setear el valor del correo
     *
     * @param correo variable para guardar el correo del profesor
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * metodo para obtener la cedula del profesor
     *
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * metodo pars setear la cedula del profesor
     * @param cedula variable para guardar la cedula del profesor
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
