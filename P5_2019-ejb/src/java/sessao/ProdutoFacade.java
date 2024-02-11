/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Categoria3;
import entidade.Produto;
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
public class ProdutoFacade extends AbstractFacade<Produto> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() 
    {
        super(Produto.class);
    }
    
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(p.pkProduto) FROM Produto p");
        Integer id =(Integer)  query.getSingleResult();
        if(id == null)
            return 0;
        return id;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
    
    public Produto findByCategoria3(Categoria3 categoria3)
    {
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.fkCategoria3 = :categoria3");
        query.setParameter("categoria3", categoria3);
        return (Produto) query.getSingleResult();
    }
    
    public List<Produto> findAllByQuantidade(Integer quantidade)
    {
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.fkCategoria3.quantidadeMaxima = :quantidade");
        query.setParameter("quantidade", quantidade);
        return  query.getResultList();
    }
    
}
