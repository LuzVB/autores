package edu.unicundi.entity;

import edu.unicundi.entity.Direccion;
import edu.unicundi.entity.Libro;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-19T13:16:44")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, Date> fecha;
    public static volatile ListAttribute<Autor, Libro> libro;
    public static volatile SingularAttribute<Autor, Boolean> estado;
    public static volatile SingularAttribute<Autor, String> apellido;
    public static volatile SingularAttribute<Autor, Direccion> direccion;
    public static volatile SingularAttribute<Autor, Integer> id;
    public static volatile SingularAttribute<Autor, String> nombre;

}