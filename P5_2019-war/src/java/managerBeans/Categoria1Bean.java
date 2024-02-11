/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Categoria1;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.Categoria1Facade;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class Categoria1Bean 
{
    @EJB
    private Categoria1Facade categoria1Facade;

    /**
     * Creates a new instance of Categoria1Bean
     */
    
    private String idCategoria1 = "";
    private Categoria1 categoria1;
    private  ReadWriteExcelFile rwf;
    public Categoria1Bean() 
    {
        this.categoria1 = new Categoria1();
        rwf = new ReadWriteExcelFile();
    }
  
    public void carregarDadosTabelaCategoria1(Object[][] categorias1)
    {
        for(int i = 0; i< categorias1.length; i++)
        {            
            categoria1.setPkCategoria1(rwf.substring(categorias1[i][0].toString(),".0"));
            categoria1.setNome(categorias1[i][1].toString());
            
            if(categoria1Facade.find(categoria1.getPkCategoria1()) == null)
                categoria1Facade.create(categoria1);        
        }
    }

    public Categoria1Facade getCategoria1Facade()
    {
        return categoria1Facade;
    }

    public void setCategoria1Facade(Categoria1Facade categoria1Facade)
    {
        this.categoria1Facade = categoria1Facade;
    }

    public Categoria1 getCategoria1() 
    {
        return categoria1;
    }

    public void setCategoria1(Categoria1 categoria1) 
    {
        this.categoria1 = categoria1;
    }
    
    public Categoria1 getCategoria1ById()
    {
       return this.categoria1Facade.find(idCategoria1);
    }

    public String getIdCategoria1() 
    {
        return idCategoria1;
    }

    public void setIdCategoria1(String idCategoria1)
    {
        this.idCategoria1 = idCategoria1;
    }
    
    
    public List<Categoria1> findAllOrderByNome()
    {
        return this.categoria1Facade.findAllOrderByNome();
    }
    
    
        
}