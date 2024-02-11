/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Categoria1;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julio
 */
@Stateless
public class Categoria1Facade extends AbstractFacade<Categoria1> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categoria1Facade() {
        super(Categoria1.class);
    }
    
    public List<Categoria1> findAllOrderByNome()
    {
        try
        
        {
            Query query = em.createQuery( "SELECT c FROM Categoria1 c ORDER BY c.nome");
            return query.getResultList();
        }
        catch(NoResultException ex)
        {
           System.err.println("Nao foi encontrado registo: " + ex.getMessage());
        }
        catch(EJBException ex)
        {
          System.err.println("Nao foi encontrado registo: " + ex.getMessage());
        }
        return null;
    }
    
}
