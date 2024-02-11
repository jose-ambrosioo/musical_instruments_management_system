package entidade;

import entidade.Produto;
import entidade.Stock;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, Date> dataEntrada;
    public static volatile SingularAttribute<Entrada, Integer> pkEntrada;
    public static volatile SingularAttribute<Entrada, Integer> quantidadeDisponivel;
    public static volatile SingularAttribute<Entrada, Integer> quantidadeMaxima;
    public static volatile SingularAttribute<Entrada, Stock> fkStock;
    public static volatile SingularAttribute<Entrada, Produto> fkProduto;

}