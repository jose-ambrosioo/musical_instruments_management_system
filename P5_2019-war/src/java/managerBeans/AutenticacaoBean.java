/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import entidade.Pais;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sessao.PaisFacade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean 
{
    @EJB
    private PaisFacade paisFacade;

    private String usuario;
    private Conta conta;
    private ContaBean contaBean;
    public AutenticacaoBean()
    {
        inic();
    }

    public void inic()
    {
        contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
        conta = new Conta(0);
    }
    
    public String autenticar()
    {
        FacesContext fc = FacesContext.getCurrentInstance();

        usuario = contaBean.getContaLogin().getNome();
        String senha = contaBean.getContaLogin().getSenha();
        
        conta = contaBean.getContaFacade().findContaByNomeAndSenha(usuario, senha);
        System.err.println("Autenticacao : conta : " + conta);
        System.err.println("Nome : " + usuario + "\n senha : " + senha);
        
        if (contaBean.getContaFacade().autenticar(usuario, senha))
        {
            ExternalContext ec = fc.getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(false);
            session.setAttribute("usuario", this.usuario);
            return "home";
        }

        UtilMensagensBean.adicionarMensagemDeErro("Usuario ou senha invalida");
        return "login";
    }

    public String registrarSaida()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(false);
        session.removeAttribute("usuario");
        return "login.xhtml";
    }

    public Conta getConta()
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }
    
    
}