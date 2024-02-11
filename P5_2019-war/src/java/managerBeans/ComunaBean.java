/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Comuna;
import entidade.Municipio;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.ComunaFacade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;


/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ComunaBean 
{
    @EJB
    private ComunaFacade comunaFacade;

    /**
     * Creates a new instance of ComunaBean
     */
    
    private MunicipioBean municipioBean;
    private int idComuna = 0;
    public ComunaBean()
    {
       municipioBean = (MunicipioBean) GeradorCodigo.getInstanciaBean("municipioBean");
    }

    public ComunaFacade getComunaFacade() {
        return comunaFacade;
    }

    public void setComunaFacade(ComunaFacade comunaFacade) {
        this.comunaFacade = comunaFacade;
    }

    void carregarDadosTabelaComuna(Object[][] comunas) 
    {
         ComunaBean comunaBean =(ComunaBean) GeradorCodigo.getInstanciaBean("comunaBean");
         ReadWriteExcelFile rwf = new ReadWriteExcelFile();
            for(int i = 0; i< comunas.length; ++i)
            {
                System.err.println("-------------------------------------------------------------");
                Integer idComuna = rwf.converteNumericoInteiro(comunas[i][0].toString());
                
                Comuna comuna = comunaFacade.find(idComuna);
                if( comuna != null)
                {
                   
                    String nome = comunas[i][1].toString();
                    Integer idMunicipio = rwf.converteNumericoInteiro(comunas[i][2].toString());
                    
                    System.err.println("id Comuna : "  + idComuna);
                    System.err.println("Nome : "  + nome);
                    System.err.println("fk id Provincia : "  + idMunicipio);
                    
                    comuna.setNome(nome);  
                    comuna.setFkMunicipio(municipioBean.getMunicipioFacade().find(idMunicipio));
                    comunaFacade.edit(comuna);
                    System.err.println("Comuna Atualizada");
                }
                else
                {
                    Comuna novaComuna = new Comuna(idComuna);
                    String nome = comunas[i][1].toString();
                    Integer idMunicipio = rwf.converteNumericoInteiro(comunas[i][2].toString());
                    novaComuna.setNome(nome);
                    novaComuna.setFkMunicipio(municipioBean.getMunicipioFacade().find(idMunicipio));
                    comunaFacade.create(novaComuna);
                    System.err.println("Comuna inserida");   
                }
           } 
    }

    public int getIdComuna() 
    {
        return idComuna;
    }

    public void setIdComuna(int idComuna) 
    {
        this.idComuna = idComuna;
    }
    
    public Comuna getComunaById()
    {
        return this.comunaFacade.find(idComuna);
    }
    
    public List<Comuna>  findAllFromMunicipioOrderedByNome(int pkMunicipio)
    {
       return this.comunaFacade.findAllFromMunicipioOrderedByNome(pkMunicipio);
    }
  
}