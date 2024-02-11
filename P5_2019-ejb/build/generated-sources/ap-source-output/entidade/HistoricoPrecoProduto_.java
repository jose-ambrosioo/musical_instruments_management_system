package entidade;

import entidade.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(HistoricoPrecoProduto.class)
public class HistoricoPrecoProduto_ { 

    public static volatile SingularAttribute<HistoricoPrecoProduto, Float> valor;
    public static volatile SingularAttribute<HistoricoPrecoProduto, Integer> pkHistoricoPrecoProduto;
    public static volatile SingularAttribute<HistoricoPrecoProduto, Produto> fkProduto;
    public static volatile SingularAttribute<HistoricoPrecoProduto, Date> dataCadastro;

}