package entidade;

import entidade.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(FormaPagamento.class)
public class FormaPagamento_ { 

    public static volatile SingularAttribute<FormaPagamento, Integer> pkFormaPagamento;
    public static volatile ListAttribute<FormaPagamento, Venda> vendaList;
    public static volatile SingularAttribute<FormaPagamento, String> descricao;

}