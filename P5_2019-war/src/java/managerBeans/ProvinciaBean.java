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
import javax.persistence.NoResultException;
import sessao.PaisFacade;
import sessao.ProvinciaFacade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ProvinciaBean 
{

   @EJB
    private ProvinciaFacade provinciaFacade;
    
    private int  idProvincia;
    private List<Provincia> listaProvincia;
    private  int idPais;
    private int i;
    
    
    
    /**
     * Creates a new instance of ProvinciaBean
     */
    

    private PaisBean paisBean;
    public ProvinciaBean()
    {
       paisBean = (PaisBean) GeradorCodigo.getInstanciaBean("paisBean");
    }

    public int getIdProvincia() 
    {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) 
    {
        this.idProvincia = idProvincia;
    }
   
    public int getIdPais() 
    {
        return idPais;
    }

    public void setIdPais(int idPais) 
    {
        this.idPais = idPais;
    }

  
    public void carregarDadosTabelaProvincia(Object provincias[][])
    {
            PaisBean paisBean =(PaisBean) GeradorCodigo.getInstanciaBean("paisBean");
            ReadWriteExcelFile rwf = new ReadWriteExcelFile();
            for(int i = 0; i< provincias.length; ++i)
            {
                Integer idProvincia = rwf.converteNumericoInteiro(provincias[i][0].toString());
                Provincia provincia = provinciaFacade.find(idProvincia);
                if( provincia != null)
                {
                   
                    String nome = provincias[i][1].toString();
                    Integer idPais = rwf.converteNumericoInteiro(provincias[i][2].toString());     
                    provincia.setNome(nome);  
                    provincia.setFkPais(new Pais(idPais));
                    provinciaFacade.edit(provincia);
                    System.err.println("Provincia Atualizada");
                }
                else
                {
                    Provincia novaProvincia = new Provincia(idProvincia);
                    String nome = provincias[i][1].toString();
                    Integer idPais = rwf.converteNumericoInteiro(provincias[i][2].toString());
                    novaProvincia.setNome(nome);
                    novaProvincia.setFkPais(paisBean.getPaisFacade().find(idPais));
                    provinciaFacade.create(novaProvincia);
                    System.err.println("Provincia inserida");   
                }
           } 
    } 

    public ProvinciaFacade getProvinciaFacade() 
    {
        return provinciaFacade;
    }

    public void setProvinciaFacade(ProvinciaFacade provinciaFacade)
    {
        this.provinciaFacade = provinciaFacade;
    }
  

    public List<Provincia> findAllFromPaisOrderedByNome(int idPais)
    {
        return this.provinciaFacade.findAllFromPaisOrderedByNome(idPais);
    }
}