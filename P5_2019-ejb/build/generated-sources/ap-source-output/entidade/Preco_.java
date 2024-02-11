package entidade;

import entidade.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Preco.class)
public class Preco_ { 

    public static volatile SingularAttribute<Preco, Date> dataAtualizacao;
    public static volatile SingularAttribute<Preco, Float> valor;
    public static volatile SingularAttribute<Preco, Integer> pkPreco;
    public static volatile SingularAttribute<Preco, Produto> fkProduto;
    public static volatile SingularAttribute<Preco, Date> dataCadastro;

}