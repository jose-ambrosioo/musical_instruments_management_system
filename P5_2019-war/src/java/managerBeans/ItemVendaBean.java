/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.ItemVendaFacade;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ItemVendaBean 
{
    @EJB
    private ItemVendaFacade itemVendaFacade;

    /**
     * Creates a new instance of ItemVendaBean
     */
    
    
    public ItemVendaBean()
    {
    }

    public ItemVendaFacade getItemVendaFacade() 
    {
        return itemVendaFacade;
    }

    public void setItemVendaFacade(ItemVendaFacade itemVendaFacade) 
    {
        this.itemVendaFacade = itemVendaFacade;
    }
    
    
}
