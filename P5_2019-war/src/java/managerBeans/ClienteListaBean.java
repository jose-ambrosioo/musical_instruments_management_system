/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import java.util.List;
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
public class ClienteListaBean 
{

    /**
     * Creates a new instance of ClienteListaBean
     */
    ContaBean contaBean;
    private ListDataModel<Conta> listaClientes;
    private PessoaBean pessoaBean;
    public ClienteListaBean() 
    {
       contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
       pessoaBean = (PessoaBean) GeradorCodigo.getInstanciaBean("pessoaBean");
       listaClientes = findAllClientes();
    }
    
    public ListDataModel<Conta> findAllClientes()
    {
        contaBean.getPerfilBean().setIdPerfil(4);
        return new ListDataModel<>(contaBean.findContasByPerfil());  
    }
    
    public void excluirClientes()
    {
        Conta conta = listaClientes.getRowData();
//        System.err.println("Conta : " + conta.toString());
        contaBean.setConta(conta);
        contaBean.excluir(); 
        pessoaBean.setPessoa(conta.getFkPessoa());
        pessoaBean.excluir();
        listaClientes = findAllClientes();
    }

    public ListDataModel<Conta> getListaClientes() 
    {
        listaClientes = findAllClientes();
        return listaClientes;
    }

    public void setListaClientes(ListDataModel<Conta> listaClientes)
    {
        this.listaClientes = listaClientes;
    }
    
    
}