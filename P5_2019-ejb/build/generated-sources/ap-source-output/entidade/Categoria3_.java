package entidade;

import entidade.Categoria2;
import entidade.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Categoria3.class)
public class Categoria3_ { 

    public static volatile SingularAttribute<Categoria3, String> pkCategoria3;
    public static volatile SingularAttribute<Categoria3, Categoria2> fkCategoria2;
    public static volatile SingularAttribute<Categoria3, Integer> quantidadeMaxima;
    public static volatile ListAttribute<Categoria3, Produto> produtoList;
    public static volatile SingularAttribute<Categoria3, String> nome;

}