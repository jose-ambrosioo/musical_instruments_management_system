/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Pais;
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
public class ProvinciaFacade extends AbstractFacade<Provincia> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }
    
    public  List<Provincia> findAllFromPaisOrderedByNome(Integer idPais) 
    {
        List<Provincia> lista = new ArrayList<Provincia>();
        try
        {
           
            Query query = em.createQuery("SELECT p FROM Provincia p WHERE p.fkPais.pkPais = :idPais");
            query.setParameter("idPais", idPais);
            lista = query.getResultList(); 
            System.out.println("lista : " + lista);
        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(EJBException ex)
        {
            System.err.println("erro na procura : "+ ex.getMessage());
        }
       
        return  lista;
    }
}
