/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Municipio;
import entidade.Pais;
import entidade.Provincia;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.MunicipioFacade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class MunicipioBean 
{

   @EJB
    private MunicipioFacade municipioFacade;

    /**
     * Creates a new instance of MunicipioBean
     */
    
    private int idMunicipio = 0;
    private ProvinciaBean provinciaBean;
    
    public MunicipioBean() 
    {
        provinciaBean = (ProvinciaBean) GeradorCodigo.getInstanciaBean("provinciaBean");
    }
    
    public void carregarDadosTabelaMunicipio(Object municipios[][])
    {
            ProvinciaBean provinciaBean = (ProvinciaBean) GeradorCodigo.getInstanciaBean("provinciaBean");
            ReadWriteExcelFile rwf = new ReadWriteExcelFile();
            
            for(int i = 0; i< municipios.length; ++i)
            {
                System.err.println("-------------------------------------------------------------");
                Integer idMunicipio = rwf.converteNumericoInteiro(municipios[i][0].toString());
                
                Municipio municipio = municipioFacade.find(idMunicipio);
                if( municipio != null)
                {
                   
                    String nome = municipios[i][1].toString();
                    Integer idProvincia = rwf.converteNumericoInteiro(municipios[i][2].toString());
                    
                    System.err.println("id Municipio : "  + idMunicipio);
                    System.err.println("Nome : "  + nome);
                    System.err.println("fk id Provincia : "  + idProvincia);
                    
                    municipio.setNome(nome);  
                    municipio.setFkProvincia(provinciaBean.getProvinciaFacade().find(idProvincia));
                    municipioFacade.edit(municipio);
                    System.err.println("Municipio Atualizada");
                }
                else
                {
                    Municipio novaMunicipio = new Municipio(idMunicipio);
                    String nome = municipios[i][1].toString();
                    Integer idProvincia = rwf.converteNumericoInteiro(municipios[i][2].toString());
                    novaMunicipio.setNome(nome);
                    novaMunicipio.setFkProvincia(provinciaBean.getProvinciaFacade().find(idProvincia));
                    municipioFacade.create(novaMunicipio);
                    System.err.println("Municipio inserida");   
                }
           } 
    } 

    public MunicipioFacade getMunicipioFacade() 
    {
        return municipioFacade;
    }

    public void setMunicipioFacade(MunicipioFacade municipioFacade) {
        this.municipioFacade = municipioFacade;
    }

    public int getIdMunicipio() 
    {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) 
    {
        this.idMunicipio = idMunicipio;
    }
    
    
    public  List<Municipio>  findAllFromProvinciaOrderedByNome(int pkProvincia)
    {
        return this.municipioFacade.findAllFromProvinciaOrderedByNome(pkProvincia);
    }
            
    
}