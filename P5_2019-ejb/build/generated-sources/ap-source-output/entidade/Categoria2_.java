package entidade;

import entidade.Categoria1;
import entidade.Categoria3;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Categoria2.class)
public class Categoria2_ { 

    public static volatile SingularAttribute<Categoria2, String> pkCategoria2;
    public static volatile SingularAttribute<Categoria2, Categoria1> fkCategoria1;
    public static volatile ListAttribute<Categoria2, Categoria3> categoria3List;
    public static volatile SingularAttribute<Categoria2, String> nome;

}