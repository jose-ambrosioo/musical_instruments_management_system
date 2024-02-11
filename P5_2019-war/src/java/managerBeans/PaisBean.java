/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Pais;
import entidade.Provincia;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.MunicipioFacade;
import sessao.PaisFacade;
import sessao.ProvinciaFacade;
import util.ReadWriteExcelFile;
/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class PaisBean 
{
    @EJB
    private PaisFacade paisFacade;
   
    
    /**
     * Creates a new instance of PaisBean
     */
    private Pais pais;
    private int  idPais = 0;
    
    public PaisBean() 
    {
        
    }

    public Pais getPais() 
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }

    public int getIdPais() 
    {
        return idPais;
    }

    public void setIdPais(int idPais) 
    {
        this.idPais = idPais;
    }
   
   
    public void carregarDadosTabelaPais(Object paises[][])
    {
            ReadWriteExcelFile rwf = new ReadWriteExcelFile();
            for(int i = 0; i< paises.length; ++i)
            {
                Integer idPais = rwf.converteNumericoInteiro(paises[i][0].toString());
                 
                Pais pais = paisFacade.find(idPais);
                if( pais != null)
                {
                    String nome = paises[i][1].toString();
                    pais.setNome(nome);
                    paisFacade.edit(pais);
                }
                else
                {
                    Pais novoPais = new Pais(idPais);
                    String nome = paises[i][1].toString();
                    novoPais.setNome(nome);
                    paisFacade.create(novoPais);    
                }
           } 
    }

    public PaisFacade getPaisFacade() 
    {
        return paisFacade;
    }

    public void setPaisFacade(PaisFacade paisFacade)
    {
        this.paisFacade = paisFacade;
    }
    
    public List<Pais> findAllOrderedByNome()
    {
        return this.paisFacade.findAllOrderedByNome();
    }
    
 
}