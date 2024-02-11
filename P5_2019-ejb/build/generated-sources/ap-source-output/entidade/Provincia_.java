package entidade;

import entidade.Municipio;
import entidade.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Integer> pkProvincia;
    public static volatile SingularAttribute<Provincia, Pais> fkPais;
    public static volatile SingularAttribute<Provincia, String> nome;
    public static volatile ListAttribute<Provincia, Municipio> municipioList;

}