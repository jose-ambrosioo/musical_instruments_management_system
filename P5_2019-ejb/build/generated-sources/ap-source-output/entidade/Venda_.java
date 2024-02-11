package entidade;

import entidade.Conta;
import entidade.FormaPagamento;
import entidade.ItemVenda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Date> dataVenda;
    public static volatile SingularAttribute<Venda, Float> totalVenda;
    public static volatile SingularAttribute<Venda, Integer> pkVenda;
    public static volatile ListAttribute<Venda, ItemVenda> itemVendaList;
    public static volatile SingularAttribute<Venda, FormaPagamento> fkFormaPagamento;
    public static volatile SingularAttribute<Venda, Conta> fkConta;

}