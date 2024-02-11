/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Categoria1;
import entidade.Categoria2;
import entidade.Categoria3;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.Categoria3Facade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class Categoria3Bean 
{
    @EJB
    private Categoria3Facade categoria3Facade;

    /**
     * Creates a new instance of Categoria3Bean
     */
    private ReadWriteExcelFile rwf;
    private Categoria2Bean categoria2Bean;
    private String idCategoria3 = "";
    public Categoria3Bean() 
    {
        rwf = new ReadWriteExcelFile();
        categoria2Bean = (Categoria2Bean) GeradorCodigo.getInstanciaBean("categoria2Bean");
    }

    void carregarDadosTabelaCategoria3(Object[][] matrizData) 
    {
        for(int i = 0; i< matrizData.length; i++)
        {   
            Categoria3 categoria3 = new Categoria3();
            categoria3.setPkCategoria3(rwf.substring(matrizData[i][0].toString(),".0"));
            categoria3.setNome(matrizData[i][1].toString());
            categoria3.setQuantidadeMaxima(rwf.converteNumericoInteiro(matrizData[i][3].toString()));
            Categoria2 categoria2 = categoria2Bean.getCategoria2Facade().find(rwf.gerarCodigoFK(categoria3.getPkCategoria3()));
            categoria3.setFkCategoria2(categoria2);
            
            if(categoria3Facade.find(categoria3.getPkCategoria3()) == null)
                categoria3Facade.create(categoria3);  
            else
                categoria3Facade.edit(categoria3);
        }
    }
    
    public List<Categoria3> findCategorias3ByCategoria2OrderByNome()
    {
       System.err.println("fk : " + categoria2Bean.getIdCategoria2());
       Categoria2 categoria2 = categoria2Bean.getCategoria2Facade().find(categoria2Bean.getIdCategoria2());
       
       return categoria3Facade.findCategorias3ByCategoria2OrderByNome(categoria2);
    }

    public String getIdCategoria3()
    {
        return idCategoria3;
    }

    public void setIdCategoria3(String idCategoria3) 
    {
        this.idCategoria3 = idCategoria3;
    }

    public Categoria3Facade getCategoria3Facade()
    {
        return categoria3Facade;
    }

    public void setCategoria3Facade(Categoria3Facade categoria3Facade) 
    {
        this.categoria3Facade = categoria3Facade;
    }
    
    
    public void alterar( Categoria3 categoria3)
    {
       this.categoria3Facade.edit(categoria3);
    }
    
}