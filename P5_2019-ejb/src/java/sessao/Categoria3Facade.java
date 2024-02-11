/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Categoria1;
import entidade.Categoria2;
import entidade.Categoria3;
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
public class Categoria3Facade extends AbstractFacade<Categoria3> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categoria3Facade() {
        super(Categoria3.class);
    }
    
    public List<Categoria3> findCategorias3ByCategoria2OrderByNome(Categoria2 fkCategoria2)
    {
        List<Categoria3> lista = new ArrayList<Categoria3>();
        try
        {
           
            Query query = em.createQuery("SELECT c FROM Categoria3 c WHERE c.fkCategoria2 = :fkCategoria2 ORDER BY c.nome");
            query.setParameter("fkCategoria2", fkCategoria2);
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
