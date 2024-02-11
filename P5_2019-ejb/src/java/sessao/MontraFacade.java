/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Montra;
import entidade.Produto;
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
public class MontraFacade extends AbstractFacade<Montra> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public MontraFacade() 
    {
        super(Montra.class);
    }
    
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(m.pkMontra) FROM Montra m");
        Integer idMontra =(Integer)  query.getSingleResult();
        if(idMontra==null)
            return 0;
        return idMontra;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
    
    public Montra findByProduto(Integer fkProduto)
    {
        try
        {
            Query query = em.createQuery("SELECT m FROM Montra m WHERE m.fkProduto.pkProduto = :fkProduto");
            query.setParameter("fkProduto", fkProduto);
            return (Montra) query.getSingleResult();
        }
        catch(EJBException ex)
        {
            System.err.println("Erro: Falha na consulta " + ex.getMessage() );
        }
        catch(NoResultException ex)
        {
            System.err.println("Erro:Nao foi encontrado nenhum registo " + ex.getMessage());
        }
        return null;
    }

    public List<Montra> findAllOrderedByNome() 
    {
       Query query = em.createQuery("SELECT m FROM Montra m ORDER BY m.fkProduto.fkCategoria3.nome");
       return  query.getResultList();
    }
    
}
