/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Comuna;
import entidade.Endereco;
import entidade.Pessoa;
import entidade.Sexo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.convert.DateTimeConverter;
import org.primefaces.event.SelectEvent;
import sessao.EnderecoFacade;
import sessao.PessoaFacade;
import sessao.SexoFacade;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class PessoaBean 
{
    @EJB
    private PessoaFacade pessoaFacade;
    
    private Pessoa pessoa;
    private int idEndereco;
    private Endereco endereco;
    private EnderecoBean enderecoBean;
    private Sexo sexo;
    private SexoBean sexoBean;
    private int idSexo = 0;
    private ComunaBean comunaBean;
    /**
     * Creates a new instance of PessoaBean
     */
    
    public PessoaBean() 
    {
        sexoBean = (SexoBean) GeradorCodigo.getInstanciaBean("sexoBean");
        comunaBean = (ComunaBean) GeradorCodigo.getInstanciaBean("comunaBean");
        enderecoBean = (EnderecoBean) GeradorCodigo.getInstanciaBean("enderecoBean");
        pessoa = new Pessoa();
        endereco = new Endereco();
        sexo = new Sexo();
    }

    public Pessoa getPessoa() 
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) 
    {
        this.pessoa = pessoa;
    }

     public void handleDateSelect(SelectEvent event) 
     {
//        dataNascimento = (Date) event.getObject();
     }
    
   
    
    public String toString()
    {
        return  "----------Dados da pessoa--------\n"
                + "\n id da proxima Pessoa " + this.pessoaFacade.getProximoId()
                + "\n nome Completo : " + pessoa.getNome()
                + "\n Data de nascimento : " + pessoa.getDataNascimento()
//                + "\n Sexo : " + pessoa.getFkSexo().getNome()
                +"\n telefone : " +  pessoa.getNumeroTelefone()
                +"\n email : " + pessoa.getEmail()
//                +"\n  id da comuna : " + idComuna
//                +"\n id  Endereco : " + pessoa.getFkEndereco().getPkEndereco()
                +"\n rua : " + pessoa.getFkEndereco().getRua()
                +"\n Numero da casa : " + pessoa.getFkEndereco().getNumeroCasa();            
    }
    
    
    
    public void cadastrar()
    {

        Comuna comuna = comunaBean.getComunaFacade().find(endereco.getFkComuna().getPkComuna());
        Sexo sexo = sexoBean.getSexoFacade().find(idSexo);
        if(comuna != null && sexo!= null)
        {
            endereco.setFkComuna(comuna);
            enderecoBean.setEndereco(endereco);
            enderecoBean.cadastrarEndereco(endereco);
            Integer idPessoa =(Integer)this.pessoaFacade.getProximoId();
            pessoa.setPkPessoa(idPessoa);
            pessoa.setFkSexo(sexo);
            this.endereco = enderecoBean.getEndereco();
            pessoa.setFkEndereco( this.endereco);
            System.err.println(toString());
            this.pessoaFacade.create(pessoa);
            System.err.println("pessoa cadastrada com sucesso"); 
        }
    }
    
   // -------- metodos das defesas ----------------------------------------
//    public List<String> findAllApelidos()
//    {
//        return this.pessoaFacade.findAllApelidos();
//    }
//    
//    public List<String> findAllDominios()
//    {
//        return this.pessoaFacade.findAllDominios();
//    }
      
    
    public List<Pessoa> findAll()
    {
        return this.pessoaFacade.findAll();
    }
    
    public void excluir()
    {
       this.pessoaFacade.remove(pessoa);
    }
    
    
   public String getDataCadastro()
   {
       Calendar calendario = Calendar.getInstance();
       String dataCadastro = calendario.get(calendario.YEAR)  + "-" + (calendario.get(calendario.MONTH) + 1) + "-" + calendario.get(calendario.DAY_OF_MONTH);
       return dataCadastro;
   }

    public EnderecoBean getEnderecoBean() 
    {
        return enderecoBean;
    }

    public void setEnderecoBean(EnderecoBean enderecoBean)
    {
        this.enderecoBean = enderecoBean;
    }

    public PessoaFacade getPessoaFacade() 
    {
        return pessoaFacade;
    }

    public void setPessoaFacade(PessoaFacade pessoaFacade) 
    {
        this.pessoaFacade = pessoaFacade;
    }

    public int getIdSexo() 
    {
        return idSexo;
    }

    public void setIdSexo(int idSexo) 
    {
        this.idSexo = idSexo;
    }

    public SexoBean getSexoBean()
    {
        return sexoBean;
    }

    public void setSexoBean(SexoBean sexoBean) 
    {
        this.sexoBean = sexoBean;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }
    
}