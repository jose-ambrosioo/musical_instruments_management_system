package entidade;

import entidade.Conta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Integer> pkPerfil;
    public static volatile ListAttribute<Perfil, Conta> contaList;
    public static volatile SingularAttribute<Perfil, String> nome;

}