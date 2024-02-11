/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Venda;
import java.util.ArrayList;
import java.util.Date;
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
public class VendaFacade extends AbstractFacade<Venda> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendaFacade() {
        super(Venda.class);
    }
    
    public Integer getUltimoId()
    {
        Query query = em.createQuery("SELECT MAX(p.pkVenda) FROM Venda p");
        Integer id = (Integer)  query.getSingleResult();
        if (id == null)
            return 0;
        return id;
    }
    
    public int getProximoId()
    {
        return getUltimoId() + 1;
    }
    
    public List<Venda> findDefesa(ArrayList<String> nomeOperadorasSelected, ArrayList<String> dominiosEmais,ArrayList<String> apelidos,Date data1,Date data2,float valor1,float valor2)
    {
//        Query query = em.createQuery("SELECT v FROM Venda v WHERE v.dataVenda BETWEEN :data1 AND :data2 AND v.totalVenda BETWEEN :valor1 AND :valor2 AND v.fkConta.fkPessoa.nome LIKE '%" + apelidos   + );
       return null; 
    }
    
}
