/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.FormaPagamento;
import entidade.Venda;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.VendaFacade;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class VendaBean 
{
    @EJB
    private VendaFacade vendaFacade;

    /**
     * Creates a new instance of VendaBean
     */
  
    private FormaPagamento formaPagamento;
    private Venda venda;
    public VendaBean() 
    {
      inic();
    }
    
    public void inic()
    {
        formaPagamento  = new FormaPagamento(0);
        venda = new Venda(0);
    }
    
    public FormaPagamento getFormaPagamento() 
    {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) 
    {
        this.formaPagamento = formaPagamento;
    }

    public VendaFacade getVendaFacade() 
    {
        return vendaFacade;
    }

    public void setVendaFacade(VendaFacade vendaFacade)
    {
        this.vendaFacade = vendaFacade;
    }
    
    public void cadastrar(Venda venda)
    {
        this.vendaFacade.create(venda);
    }

    public Venda getVenda() 
    {
        return venda;
    }

    public void setVenda(Venda venda) 
    {
        this.venda = venda;
    }
    
    public List<Venda> findAll()
    {
        return this.vendaFacade.findAll();
    }
    
    
}
