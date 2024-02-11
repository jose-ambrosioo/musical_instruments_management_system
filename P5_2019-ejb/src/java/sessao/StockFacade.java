/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Produto;
import entidade.Stock;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author julio
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public StockFacade() 
    {
        super(Stock.class);
    }
    
     public Stock findStockByProduto(Produto produto)
    {
        try
        {
            Query query = em.createQuery("SELECT s FROM Stock s WHERE s.fkProduto = :produto");
            query.setParameter("produto", produto);
            return (Stock) query.getSingleResult();
        }
        catch(EJBException ex)
        {
            System.err.println("StockFacade:findStockByProduto, Erro: Falha na consulta" );
        }
        catch(NoResultException ex)
        {
            System.err.println("StockFacade:findStockByProduto,Erro:Nao foi encontrado nenhum registo");
        }

       return null;
    }
     
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(s.pkStock) FROM Stock s");
        Integer id =(Integer)  query.getSingleResult();
        if(id == null)
            return 0;
        return id;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }

    public List<Stock> findAllProdutoOrderedByNome() 
    {
            try
            {
                Query query = em.createQuery("SELECT s FROM Stock s WHERE s.fkProduto.precoList.pkPreco > 0 ORDER BY s.fkProduto.fkCategoria3.nome");
                return  query.getResultList();
            }
            catch(EJBException ex)
            {
                System.err.println("StockFacade:findStockByProduto, Erro: Falha na consulta" );
            }
            catch(NoResultException ex)
            {
                System.err.println("StockFacade:findStockByProduto,Erro:Nao foi encontrado nenhum registo");
            }
           return null;
    }  
    
}
