package entidade;

import entidade.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Sexo.class)
public class Sexo_ { 

    public static volatile SingularAttribute<Sexo, String> nome;
    public static volatile SingularAttribute<Sexo, Integer> pkSexo;
    public static volatile ListAttribute<Sexo, Pessoa> pessoaList;

}