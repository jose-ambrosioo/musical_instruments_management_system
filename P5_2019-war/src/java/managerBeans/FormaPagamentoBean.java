/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.FormaPagamento;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.FormaPagamentoFacade;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class FormaPagamentoBean 
{
    @EJB
    private FormaPagamentoFacade formaPagamentoFacade;

    /**
     * Creates a new instance of FormaPagamentoBean
     */
    
    public FormaPagamentoBean() 
    {
    }
    
    
    public List<FormaPagamento> findAll()
    {
        return this.formaPagamentoFacade.findAll();
    }

    
    public FormaPagamentoFacade getFormaPagamentoFacade() 
    {
        return formaPagamentoFacade;
    }

    public void setFormaPagamentoFacade(FormaPagamentoFacade formaPagamentoFacade) 
    {
        this.formaPagamentoFacade = formaPagamentoFacade;
    }
    
   
}
