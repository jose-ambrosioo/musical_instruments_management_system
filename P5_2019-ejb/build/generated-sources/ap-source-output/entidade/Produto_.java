package entidade;

import entidade.Categoria3;
import entidade.Entrada;
import entidade.Fornecedor;
import entidade.HistoricoPrecoProduto;
import entidade.ItemVenda;
import entidade.Montra;
import entidade.Preco;
import entidade.Stock;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile ListAttribute<Produto, Preco> precoList;
    public static volatile SingularAttribute<Produto, Categoria3> fkCategoria3;
    public static volatile SingularAttribute<Produto, Fornecedor> fkFornecedor;
    public static volatile ListAttribute<Produto, Stock> stockList;
    public static volatile SingularAttribute<Produto, String> imagem;
    public static volatile ListAttribute<Produto, Entrada> entradaList;
    public static volatile ListAttribute<Produto, HistoricoPrecoProduto> historicoPrecoProdutoList;
    public static volatile SingularAttribute<Produto, Integer> pkProduto;
    public static volatile ListAttribute<Produto, ItemVenda> itemVendaList;
    public static volatile ListAttribute<Produto, Montra> montraList;

}