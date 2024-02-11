/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Sexo;
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
public class SexoFacade extends AbstractFacade<Sexo> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public SexoFacade() 
    {
        super(Sexo.class);
    }
    
     public List<Sexo> findAllOrderByNome()
    {
        Query query = em.createQuery("SELECT s FROM Sexo s ORDER BY s.nome");
        return  query.getResultList(); 
    }
}
