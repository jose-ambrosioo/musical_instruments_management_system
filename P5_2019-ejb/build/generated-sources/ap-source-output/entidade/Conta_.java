package entidade;

import entidade.Perfil;
import entidade.Pessoa;
import entidade.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Conta.class)
public class Conta_ { 

    public static volatile SingularAttribute<Conta, Integer> pkConta;
    public static volatile SingularAttribute<Conta, String> senha;
    public static volatile ListAttribute<Conta, Venda> vendaList;
    public static volatile SingularAttribute<Conta, Pessoa> fkPessoa;
    public static volatile SingularAttribute<Conta, String> nome;
    public static volatile SingularAttribute<Conta, Perfil> fkPerfil;

}