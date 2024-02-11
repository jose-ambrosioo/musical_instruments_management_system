/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.ItemVenda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julio
 */
@Stateless
public class ItemVendaFacade extends AbstractFacade<ItemVenda> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ItemVendaFacade() 
    {
        super(ItemVenda.class);
    }
    
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(p.pkItemVenda) FROM ItemVenda p");
        Integer id =(Integer)  query.getSingleResult();
        if(id == null)
            return 0;
        return id;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
}
