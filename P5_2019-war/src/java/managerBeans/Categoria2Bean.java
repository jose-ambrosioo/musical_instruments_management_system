/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Categoria1;
import entidade.Categoria2;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.Categoria2Facade;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class Categoria2Bean
{
    @EJB
    private Categoria2Facade categoria2Facade;

    /**
     * Creates a new instance of Categoria2Bean
     */
    private Categoria1Bean categoria1Bean;
    private ReadWriteExcelFile rwf;
    private String idCategoria2 = "";
    public Categoria2Bean() 
    {
        categoria1Bean = (Categoria1Bean) GeradorCodigo.getInstanciaBean("categoria1Bean");
        rwf = new ReadWriteExcelFile();
    }
    
    public void carregarDadosTabelaCategoria2(Object[][] categorias2)
    {
        
        for(int i = 0; i< categorias2.length; i++)
        {   
            Categoria2 categoria2 = new Categoria2();
            categoria2.setPkCategoria2(rwf.substring(categorias2[i][0].toString(),".0"));
            categoria2.setNome(categorias2[i][1].toString());
            Categoria1 categoria1 = categoria1Bean.getCategoria1Facade().find(rwf.gerarCodigoFK(categoria2.getPkCategoria2()).trim());
            categoria2.setFkCategoria1(categoria1);   
            
            if(categoria2Facade.find(categoria2.getPkCategoria2()) == null)
                categoria2Facade.create(categoria2);  
            else
                categoria2Facade.edit(categoria2);
        }
    }

    public Categoria2Facade getCategoria2Facade() 
    {
        return categoria2Facade;
    }

    public void setCategoria2Facade(Categoria2Facade categoria2Facade)
    {
        this.categoria2Facade = categoria2Facade;
    }

    public String getIdCategoria2() {
        return idCategoria2;
    }

    public void setIdCategoria2(String idCategoria2)
    {
        this.idCategoria2 = idCategoria2;
    }
    
    
    public Categoria2 getCategoria2ById()
    {
        return this.categoria2Facade.find(idCategoria2);
    }
    
    public List<Categoria2> findCategorias2ByCategoria1OrderByNome()
    {
       System.err.println("fk : " + categoria1Bean.getIdCategoria1());
       Categoria1 categoria1 = categoria1Bean.getCategoria1Facade().find(categoria1Bean.getIdCategoria1());
       
       return categoria2Facade.findCategorias2ByCategoria1OrderByNome(categoria1); 
    }
}