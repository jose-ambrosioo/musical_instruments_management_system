/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Pais;
import entidade.Sexo;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.SexoFacade;


/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class SexoBean 
{

    @EJB
    private SexoFacade sexoFacade;
    private Sexo sexo;
    private  int idSexo = 0;

    /**
     * Creates a new instance of SexoBean
     */
    
    public SexoBean() {
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public List<Sexo> listarSexo()
    {
        return this.sexoFacade.findAll();
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public SexoFacade getSexoFacade() {
        return sexoFacade;
    }

    public void setSexoFacade(SexoFacade sexoFacade) {
        this.sexoFacade = sexoFacade;
    }
    
    public Sexo getSexoById()
    {
        return this.sexoFacade.find(idSexo);
    }
    
    
    public List<Sexo> findAllOrderByNome()
    {
        return this.sexoFacade.findAllOrderByNome();
    }
    
}