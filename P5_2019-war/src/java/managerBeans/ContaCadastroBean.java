/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import entidade.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ContaCadastroBean
{

    private ContaBean contaBean;
    private PerfilBean perfilBean;
    private PessoaBean pessoaBean;
    private Conta conta;
    private String confirmarsenha ="";
    public ContaCadastroBean() 
    {
        contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
        perfilBean = (PerfilBean) GeradorCodigo.getInstanciaBean("perfilBean");
        pessoaBean = (PessoaBean) GeradorCodigo.getInstanciaBean("pessoaBean");
        conta = new Conta();
    }
    
    public void cadastrarConta(int idPerfil)
    {
        perfilBean.setIdPerfil(idPerfil);
        conta.setFkPerfil(perfilBean.getPerfilById());
        Pessoa pessoa = pessoaBean.getPessoaFacade().find(pessoaBean.getPessoaFacade().getUltimoID() );
        conta.setFkPessoa(pessoa);
        
        if(validarDadosConta())
        {
            contaBean.setConta(conta);
            contaBean.cadastrar();  
        }
    }

    
    public boolean validarDadosConta()
    {
        if(conta.getNome().equals(""))
        {
          UtilMensagensBean.adicionarMensagemDeErro("nao foi preenchido o nome do usuario");
          return false;
        }
        
       if(!conta.getSenha().equals(""))
         if(!conta.getSenha().equals(confirmarsenha))
         {
            UtilMensagensBean.adicionarMensagemDeErro("password invalida");
            return false;
         }
        return true;
    }
    
    public Conta getConta() 
    {
        return conta;
    }

    public void setConta(Conta conta) 
    {
        this.conta = conta;
    }

    public String getConfirmarsenha() 
    {
        return confirmarsenha;
    }

    public void setConfirmarsenha(String confirmarsenha) 
    {
        this.confirmarsenha = confirmarsenha;
    }
    
}