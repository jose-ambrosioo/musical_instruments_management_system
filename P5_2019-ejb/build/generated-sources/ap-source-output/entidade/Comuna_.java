package entidade;

import entidade.Endereco;
import entidade.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Comuna.class)
public class Comuna_ { 

    public static volatile SingularAttribute<Comuna, Integer> pkComuna;
    public static volatile ListAttribute<Comuna, Endereco> enderecoList;
    public static volatile SingularAttribute<Comuna, Municipio> fkMunicipio;
    public static volatile SingularAttribute<Comuna, String> nome;

}