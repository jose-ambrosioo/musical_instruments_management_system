package entidade;

import entidade.Produto;
import entidade.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Integer> pkItemVenda;
    public static volatile SingularAttribute<ItemVenda, Float> subtotal;
    public static volatile SingularAttribute<ItemVenda, Venda> fkVenda;
    public static volatile SingularAttribute<ItemVenda, Produto> fkProduto;
    public static volatile SingularAttribute<ItemVenda, Integer> quantidade;

}