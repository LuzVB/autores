package edu.unicundi.entity;

import edu.unicundi.entity.Autor;
import edu.unicundi.entity.AutorLectorPK;
import edu.unicundi.entity.Lector;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-16T21:46:05")
@StaticMetamodel(AutorLector.class)
public class AutorLector_ { 

    public static volatile SingularAttribute<AutorLector, String> infoAdicional;
    public static volatile SingularAttribute<AutorLector, Lector> lector;
    public static volatile SingularAttribute<AutorLector, AutorLectorPK> autorLectorId;
    public static volatile SingularAttribute<AutorLector, Autor> autor;

}