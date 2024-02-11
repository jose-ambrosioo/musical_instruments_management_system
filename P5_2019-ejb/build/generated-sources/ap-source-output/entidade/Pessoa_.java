package entidade;

import entidade.Conta;
import entidade.Endereco;
import entidade.Sexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-06-23T18:05:53")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, Integer> pkPessoa;
    public static volatile SingularAttribute<Pessoa, Sexo> fkSexo;
    public static volatile SingularAttribute<Pessoa, String> numeroTelefone;
    public static volatile ListAttribute<Pessoa, Conta> contaList;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Endereco> fkEndereco;
    public static volatile SingularAttribute<Pessoa, Date> dataNascimento;
    public static volatile SingularAttribute<Pessoa, String> email;

}