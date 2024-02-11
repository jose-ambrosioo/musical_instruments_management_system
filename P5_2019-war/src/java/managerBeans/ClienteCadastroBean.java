/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;


import entidade.Comuna;
import entidade.Endereco;
import entidade.Municipio;
import entidade.Pais;
import entidade.Pessoa;
import entidade.Provincia;
import entidade.Sexo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.PessoaFacade;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ClienteCadastroBean 
{
    /**
     * Creates a new instance of ClienteCadastroBean
     */
    private PessoaBean pessoaBean;
    private Pessoa pessoa;
    private Endereco endereco;
    private ContaBean contaBean;
    private int idSexo;
    public ClienteCadastroBean() 
    { 
       inic();
    }

    public void inic()
    {
        pessoaBean = (PessoaBean) GeradorCodigo.getInstanciaBean("pessoaBean");
        Pais pais = new Pais(0);
        Provincia provincia = new Provincia(0);
        provincia.setFkPais(pais);
        Municipio municipio = new Municipio(0);
        municipio.setFkProvincia(provincia);
        Comuna comuna = new Comuna(0);
        comuna.setFkMunicipio(municipio);
        endereco = new Endereco(0);
        endereco.setFkComuna(comuna);
        pessoa = new Pessoa(0);  
        
        idSexo = 0;
    }
    
    public PessoaBean getPessoaBean() 
    {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) 
    {
        this.pessoaBean = pessoaBean;
    }

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) 
    {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco) 
    {
        this.endereco = endereco;
    }
    public void cadastrar()
    {   
        pessoaBean.setIdSexo(idSexo);
        pessoaBean.setEndereco(endereco);
        pessoaBean.setPessoa(pessoa);      
        pessoaBean.cadastrar();
    }

    public int getIdSexo() 
    {
        return idSexo;
    }

    public void setIdSexo(int idSexo) 
    {
        this.idSexo = idSexo;
    }
    
    
    
}