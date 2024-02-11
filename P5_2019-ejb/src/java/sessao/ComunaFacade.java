/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Comuna;
import entidade.Municipio;
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
public class ComunaFacade extends AbstractFacade<Comuna> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunaFacade() {
        super(Comuna.class);
    }
    
    public List<Comuna>  findAllFromMunicipioOrderedByNome(int pkMunicipio)
    {
         List<Comuna> lista = new ArrayList<Comuna>();
        try
        {
           
            Query query = em.createQuery("SELECT c FROM Comuna c WHERE c.fkMunicipio.pkMunicipio = :pkMunicipio ORDER BY c.nome");
            query.setParameter("pkMunicipio", pkMunicipio);
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
