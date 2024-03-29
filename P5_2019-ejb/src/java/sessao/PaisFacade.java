/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Pais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julio
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public PaisFacade() 
    {
        super(Pais.class);
    }
    
    public List<Pais> findAllOrderedByNome()
    {
        Query query = em.createQuery("SELECT p FROM Pais p ORDER BY p.nome");
        return  query.getResultList();
    }
    
}
