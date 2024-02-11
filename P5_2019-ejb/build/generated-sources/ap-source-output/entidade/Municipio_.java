package entidade;

import entidade.Comuna;
import entidade.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile ListAttribute<Municipio, Comuna> comunaList;
    public static volatile SingularAttribute<Municipio, String> nome;
    public static volatile SingularAttribute<Municipio, Integer> pkMunicipio;
    public static volatile SingularAttribute<Municipio, Provincia> fkProvincia;

}