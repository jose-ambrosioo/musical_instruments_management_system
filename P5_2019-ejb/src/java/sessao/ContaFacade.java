/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.Conta;
import entidade.Perfil;
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
public class ContaFacade extends AbstractFacade<Conta> {
    @PersistenceContext(unitName = "P5_2017-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContaFacade() {
        super(Conta.class);
    }
    
    public Conta findContaByNomeAndSenha(String nome, String senha)
    {
        try
        {
            Query query = em.createQuery("SELECT c FROM Conta c WHERE c.nome = :nome AND c.senha = :senha ");
            query.setParameter("nome", nome);
            query.setParameter("senha", senha);
            return (Conta) query.getSingleResult();
        }
        catch(NoResultException ex)
        {
            System.out.println("Erro :Nao existe registo " + ex.getMessage());
        }
        catch(EJBException ex)
        {
            System.out.println("Erro : " + ex.getMessage());
        }
        return null;
    }
    
    public Integer getUltimoID()
    {
        Query query = em.createQuery("SELECT MAX(c.pkConta) FROM Conta c");
        Integer idConta = (Integer)  query.getSingleResult();
        if(idConta == null)
            return 0;
        
        return idConta;
    }
    
    public int getProximoId()
    {
        return getUltimoID() + 1;
    }
    
    
    public List<Conta> findContasByPerfilOrderByNome(Perfil perfil)
    {
        Query query = em.createQuery("SELECT c FROM Conta c WHERE c.fkPerfil = :perfil ORDER BY c.fkPessoa.nome");
        query.setParameter("perfil", perfil);
        return query.getResultList();
    }
    
    
    
    public boolean autenticar(String nome, String senha)
    {
        if(findContaByNomeAndSenha(nome, senha) != null)
            return true;

        return false;
    }
    
    public String findTipoPerfilByNomeUsuario(String nome)
    {
        try
        {
         Conta conta =  (Conta) em.createNamedQuery("Conta.findByNome", Conta.class).setParameter("nome", nome).getSingleResult();
         if(conta != null)
             return conta.getFkPerfil().getNome();
        }
        catch(NoResultException ex)
        {
            System.err.println("Erro : " + ex.getMessage());
        }
        catch(EJBException ex)
        {
            ex.printStackTrace();
        }
           
        return "";
    }
    
}
