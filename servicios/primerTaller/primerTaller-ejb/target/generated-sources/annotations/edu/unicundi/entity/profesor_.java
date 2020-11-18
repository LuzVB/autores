package edu.unicundi.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-16T21:46:05")
@StaticMetamodel(profesor.class)
public class profesor_ { 

    public static volatile SingularAttribute<profesor, Date> fecha;
    public static volatile SingularAttribute<profesor, String> cedula;
    public static volatile SingularAttribute<profesor, String> apellido;
    public static volatile SingularAttribute<profesor, String> correo;
    public static volatile SingularAttribute<profesor, Integer> id;
    public static volatile SingularAttribute<profesor, String> nombre;
    public static volatile SingularAttribute<profesor, Integer> edad;

}