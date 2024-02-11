/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Pessoa;
import java.util.ArrayList;
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
public class PessoaFacade extends AbstractFacade<Pessoa> 
{
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public PessoaFacade() 
    {
        super(Pessoa.class);
    }
    
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(p.pkPessoa) FROM Pessoa p");
        Integer idPais =(Integer)  query.getSingleResult();
        if(idPais == null)
            return 0;
        return idPais;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
    
    
    
//    public List<String> findAllApelidos()
//    {
//       Query query = em.createQuery("SELECT reverse(split_part(reverse(nome), ,1)) FROM Pessoa p ORDER BY p.nome");
//       List<String> rs = (ArrayList<String>)query.getResultList();
//       
//       return rs;
//    }
//    
//    public  List<String> findAllDominios()
//    {
//        Query query = em.createQuery("SELECT DISTINCT split_part(email, '@', 2) FROM Pessoa p");
//        return query.getResultList();
//    }
   
}
