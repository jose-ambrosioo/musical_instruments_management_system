/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Comuna;
import entidade.Endereco;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.EnderecoFacade;
import util.GeradorCodigo; 

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class EnderecoBean 
{

    @EJB
    private EnderecoFacade enderecoFacade;

    /**
     * Creates a new instance of EnderecoBean
     */
    private ComunaBean comunaBean;
    private Endereco endereco;
    public EnderecoBean() 
    {
        comunaBean = (ComunaBean) GeradorCodigo.getInstanciaBean("comunaBean");
        endereco = new Endereco();
 
    }
    

    public void cadastrarEndereco(Endereco endereco)
    {
         try
         {
            this.endereco = endereco;
            this.endereco.setPkEndereco(this.enderecoFacade.getProximoId());
            this.enderecoFacade.create(endereco);
             System.err.println("endereco cadastrado com sucesso");
         }
         catch(NullPointerException ex)
         {
               
         }  
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