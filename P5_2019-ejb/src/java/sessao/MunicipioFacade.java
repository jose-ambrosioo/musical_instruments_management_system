/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Municipio;
import entidade.Provincia;
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
public class MunicipioFacade extends AbstractFacade<Municipio> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public MunicipioFacade()
    {
        super(Municipio.class);
    }
    
    public List<Municipio> findAllOrderByNome() 
    {
             
        List<Municipio> lista = new ArrayList<Municipio>();
        try
        {
            Query query = em.createQuery("SELECT m FROM Municipio m ORDER BY m.nome");
            lista = query.getResultList(); 
        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(EJBException ex)
        {
            System.err.println(" findAllMunicipiosOrderByNome :erro na procura : "+ ex.getMessage());
        }
       
        return  lista;
    }

    public List<Municipio> findAllFromProvinciaOrderedByNome(int pkProvincia)
    {
        List<Municipio> lista = new ArrayList<Municipio>();
        try
        {
            Query query = em.createQuery("SELECT m FROM Municipio m WHERE m.fkProvincia.pkProvincia = :pkProvincia ORDER BY m.nome");
            query.setParameter("pkProvincia", pkProvincia);
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
