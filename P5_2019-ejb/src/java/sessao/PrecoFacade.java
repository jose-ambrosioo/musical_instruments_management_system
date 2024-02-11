/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Preco;
import entidade.Produto;
import java.util.ArrayList;
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
public class PrecoFacade extends AbstractFacade<Preco> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public PrecoFacade() {
        super(Preco.class);
    }
    
    public  List<Preco> findAllOrderedByNomeProduto() 
    {
        
       
        try
        {
            Query query = em.createQuery("SELECT p FROM Preco p ORDER BY p.fkProduto.fkCategoria3.nome");
            List<Preco> lista = query.getResultList(); 
            System.out.println("listagem : " + lista);
            return lista;
            
        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(EJBException ex)
        {
            System.err.println(" classe:PrecoFacade:findPrecosOrderByNomeProduto:erro na procura : "+ ex.getMessage());
        }
        return  null;
    }
    
    public  Preco findPrecoByProduto(Produto produto )
    {
        
       try
        {
            Query query = em.createQuery("SELECT p FROM Preco p WHERE p.fkProduto = :produto");
            query.setParameter("produto", produto);
            return (Preco) query.getSingleResult();
        }
        catch(EJBException ex)
        {
            System.err.println("Erro: Falha na consulta" );
        }
        catch(NoResultException ex)
        {
            System.err.println("Erro:Nao foi encontrado nenhum registo");
        }

       return null;
    }
    
    
    
}
