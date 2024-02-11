package entidade;

import entidade.Entrada;
import entidade.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> pkStock;
    public static volatile SingularAttribute<Stock, Integer> quantidadeDisponivel;
    public static volatile SingularAttribute<Stock, Integer> quantidadeMaxima;
    public static volatile ListAttribute<Stock, Entrada> entradaList;
    public static volatile SingularAttribute<Stock, Produto> fkProduto;

}