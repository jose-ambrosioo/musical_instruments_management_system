/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Perfil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.PerfilFacade;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class PerfilBean 
{
    @EJB
    private PerfilFacade perfilFacade;
    private Perfil perfil;
    private int idPerfil;
    
    /**
     * Creates a new instance of PerfilBean
     */
    
    public PerfilBean() {
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    public List<Perfil> findAllPerfil()
    {
        return perfilFacade.findAll();
    }
    
    public Perfil getPerfilById()
    {
       return this.perfilFacade.find(idPerfil);
    }
    
}