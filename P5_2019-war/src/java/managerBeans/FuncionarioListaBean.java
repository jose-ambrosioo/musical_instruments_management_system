/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class FuncionarioListaBean 
{

    ContaBean contaBean;
    private ListDataModel<Conta> listaFuncionarios;
    private PessoaBean pessoaBean;
    public FuncionarioListaBean() 
    {
       contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
       pessoaBean = (PessoaBean) GeradorCodigo.getInstanciaBean("pessoaBean");
       listaFuncionarios = findAllFuncionarios();
    }
    
    public ListDataModel<Conta> findAllFuncionarios()
    {
        contaBean.getPerfilBean().setIdPerfil(3);
        return new ListDataModel<>(contaBean.findContasByPerfil());  
    }
    
    public void excluirFuncionarios()
    {
        Conta conta = listaFuncionarios.getRowData();
        contaBean.setConta(conta);
        contaBean.excluir();  
        pessoaBean.setPessoa(conta.getFkPessoa());
        pessoaBean.excluir();
        listaFuncionarios = findAllFuncionarios();
    }

    public ListDataModel<Conta> getListaFuncionarios() 
    {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(ListDataModel<Conta> listaFuncionarios)
    {
        this.listaFuncionarios = listaFuncionarios;
    }
}