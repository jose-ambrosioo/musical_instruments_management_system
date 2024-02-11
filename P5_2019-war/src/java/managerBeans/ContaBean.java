/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import entidade.Perfil;
import entidade.Pessoa;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.ContaFacade;
import sessao.PerfilFacade;
import sessao.PessoaFacade;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ContaBean 
{
    @EJB
    private PerfilFacade perfilFacade;

    @EJB
    private PessoaFacade pessoaFacade;

    @EJB
    private ContaFacade contaFacade;

    /**
     * Creates a new instance of ContaBean
     */
    private int idConta;
    private Conta conta;
    private Conta contaLogin;
    
    private String nomePerfil;
    private String confirmarSenha;
    private Pessoa pessoa;
    private Perfil perfil;
    private PerfilBean perfilBean;
    public ContaBean() 
    {
        perfilBean = (PerfilBean) GeradorCodigo.getInstanciaBean("perfilBean");
        contaLogin = new Conta();
        conta = new Conta();
        pessoa = new Pessoa();
        perfil = new Perfil();
    }

    public int getIdConta()
    {
        return idConta;
    }

    public void setIdConta(int idConta) 
    {
        this.idConta = idConta;
    }

    public Conta getConta() 
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public Conta getContaLogin() 
    {
        return contaLogin;
    }

    public void setContaLogin(Conta contaLogin) 
    {
        this.contaLogin = contaLogin;
    }

    
    
    public String getNomePerfil()
    {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil)
    {
        this.nomePerfil = nomePerfil;
    }

    public String acessarSistema()
    {
        conta = this.contaFacade.findContaByNomeAndSenha(conta.getNome(), conta.getSenha());
        if (conta != null)
        {
            nomePerfil = conta.getFkPerfil().getNome();
            return "home";
        }
        return "index";
    }

    public String toString()
    {
        return "\n nome : " + conta.getNome()
                +"\n senha : " + conta.getSenha();  
    }
    
    public void cadastrar()
    {
        conta.setPkConta(this.contaFacade.getProximoId());
        this.contaFacade.create(conta); 
        UtilMensagensBean.adicionarMensagemDeSucesso("conta criada com sucesso");
        System.out.println("conta criada com sucesso:\n dados do usario : " + toString());
    }

    public void  excluir()
    {
       this.contaFacade.remove(conta);
       UtilMensagensBean.adicionarMensagemDeSucesso("Conta foi excluida");
    }
    
    public String findTipoPerfilByNomeUsuario() 
    {
       
        return this.contaFacade.findTipoPerfilByNomeUsuario(this.contaLogin.getNome());
    }

    public ContaFacade getContaFacade() 
    {
        return contaFacade;
    }

    public void setContaFacade(ContaFacade contaFacade) 
    {
        this.contaFacade = contaFacade;
    }

    
    public List<Conta> findContasByPerfil()
    {
        perfil = perfilBean.getPerfilById();
        return this.contaFacade.findContasByPerfilOrderByNome(perfil);
    }

    public PerfilBean getPerfilBean() 
    {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) 
    {
        this.perfilBean = perfilBean;
    }
    
}