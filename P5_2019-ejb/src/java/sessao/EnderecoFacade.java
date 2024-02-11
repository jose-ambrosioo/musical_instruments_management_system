/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julio
 */
@Stateless
public class EnderecoFacade extends AbstractFacade<Endereco> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnderecoFacade() {
        super(Endereco.class);
    }
    
    public int getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(e.pkEndereco) FROM Endereco e");
        Integer idEndereco =(Integer)  query.getSingleResult();
        if(idEndereco == null)
            return 0;
        return idEndereco;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
}
