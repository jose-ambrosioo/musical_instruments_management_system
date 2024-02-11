package entidade;

import entidade.Comuna;
import entidade.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, Integer> pkEndereco;
    public static volatile SingularAttribute<Endereco, Integer> numeroCasa;
    public static volatile SingularAttribute<Endereco, Comuna> fkComuna;
    public static volatile SingularAttribute<Endereco, String> rua;
    public static volatile ListAttribute<Endereco, Pessoa> pessoaList;

}