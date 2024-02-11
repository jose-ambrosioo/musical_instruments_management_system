/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Categoria1;
import entidade.Categoria2;
import entidade.Comuna;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julio
 */
@Stateless
public class Categoria2Facade extends AbstractFacade<Categoria2> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categoria2Facade() {
        super(Categoria2.class);
    }
    
     public List<Categoria2> findCategorias2ByCategoria1OrderByNome(Categoria1 fkCategoria1)
    {
        List<Categoria2> lista = new ArrayList<Categoria2>();
        try
        {
           
            Query query = em.createQuery("SELECT c FROM Categoria2 c WHERE c.fkCategoria1 = :fkCategoria1 ORDER BY c.nome");
            query.setParameter("fkCategoria1", fkCategoria1);
            lista = query.getResultList(); 
            System.out.println("lista : " + lista);
        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(EJBException ex)
        {
            System.err.println(" findProvinciasByIdPais :erro na procura : "+ ex.getMessage());
        }
        
        return  lista;
    }   
}
