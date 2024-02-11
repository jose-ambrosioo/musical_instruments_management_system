/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Categoria1;
import entidade.Categoria2;
import entidade.Categoria3;
import entidade.Comuna;
import entidade.Municipio;
import entidade.Pais;
import entidade.Produto;
import entidade.Provincia;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Constantes;
import util.GeradorCodigo;
import util.ReadWriteExcelFile;
import util.PathManager;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class CarregarTabelasBean 
{

     /**
     * Creates a new instance of CarregarTabelasBean
     */
    private ProvinciaBean provinciaBean;
    private PaisBean paisBean;
    private MunicipioBean municipioBean;
    private ComunaBean comunaBean;
    private Categoria1Bean categoria1Bean;
    private Categoria2Bean categoria2Bean;
    private Categoria3Bean categoria3Bean;
    private ProdutoBean produtoBean;
    ReadWriteExcelFile rwf;
    private StockEntradaProdutoBean stockEntradaProdutoBean;
    public CarregarTabelasBean() 
    {
        paisBean = (PaisBean) GeradorCodigo.getInstanciaBean("paisBean");
        provinciaBean  = (ProvinciaBean) GeradorCodigo.getInstanciaBean("provinciaBean");
        municipioBean = (MunicipioBean)GeradorCodigo.getInstanciaBean("municipioBean");
        comunaBean = (ComunaBean)GeradorCodigo.getInstanciaBean("comunaBean");
        categoria1Bean = (Categoria1Bean) GeradorCodigo.getInstanciaBean("categoria1Bean");
        categoria2Bean = (Categoria2Bean) GeradorCodigo.getInstanciaBean("categoria2Bean");
        categoria3Bean = (Categoria3Bean) GeradorCodigo.getInstanciaBean("categoria3Bean");
        produtoBean = (ProdutoBean) GeradorCodigo.getInstanciaBean("produtoBean");
        stockEntradaProdutoBean = (StockEntradaProdutoBean) GeradorCodigo.getInstanciaBean("stockEntradaProdutoBean");

        rwf = new ReadWriteExcelFile();
    }
    
    
    public void carregarTodasTabelas()
    {
       carregarTabelaPais();
       carregarTabelaProvincia();
       carregarTabelaMunicipio();
       carregarTabelaComunas();
       carregarTabelaCategoria1();
       carregarTabelaCategoria2();
       carregarTabelaCategoria3();
       produtoBean.carregarDados();
       stockEntradaProdutoBean.carregarDados();
    }
    
    public String carregarTabelaPais() 
    {
        String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_TABELAS);        
        urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");
     
        rwf.readXLSFile(0,urlFile, new Pais());
        paisBean.carregarDadosTabelaPais(rwf.getMatrizData());
        UtilMensagensBean.adicionarMensagemDeSucesso("Tabela de Paises carregadas com sucesso");
        
        return "home";
    }
    
    public String carregarTabelaProvincia()
    {
        
           String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_TABELAS);
           urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");

           rwf.readXLSFile(1,urlFile,new Provincia());
           provinciaBean.carregarDadosTabelaProvincia(rwf.getMatrizData());
            
            UtilMensagensBean.adicionarMensagemDeSucesso("Tabela Provincia carregada com sucesso");
            
        return "home";
    }
    
    public String carregarTabelaMunicipio()
    {
        String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_TABELAS);
        urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");

        System.err.println("Caminho  : " + urlFile);
        rwf.readXLSFile(2,urlFile, new Municipio());
        municipioBean.carregarDadosTabelaMunicipio(rwf.getMatrizData());
        UtilMensagensBean.adicionarMensagemDeSucesso("Tabela de municipios carregada com sucesso");
            
        return "home";
    }
    
   public String carregarTabelaComunas()
   {
        String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_TABELAS);
        urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");

        rwf.readXLSFile(3,urlFile,new Comuna());
        comunaBean.carregarDadosTabelaComuna(rwf.getMatrizData());
        UtilMensagensBean.adicionarMensagemDeSucesso("Tabela de comunas carregada com sucesso");
       
        return "home";  
   }
    
   public String carregarTabelaCategoria1()
   {
//        
       String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_PORTFOLIO);
       urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");

       rwf.readXLSFile(1,urlFile, new Categoria1());
       categoria1Bean.carregarDadosTabelaCategoria1(rwf.getMatrizData());
       UtilMensagensBean.adicionarMensagemDeSucesso("Categorias de nivel 1 Carregada com sucesso");
           
        return "home";  
   }
   
   public String carregarTabelaCategoria2()
   {
       String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_PORTFOLIO);
       urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");

        rwf.readXLSFile(2,urlFile,new Categoria2());
        categoria2Bean.carregarDadosTabelaCategoria2(rwf.getMatrizData());
        UtilMensagensBean.adicionarMensagemDeSucesso("Categorias de nivel 2 Carregada com sucesso");
       
       return "home";  
   }
   
   public String carregarTabelaCategoria3()
   {
        String urlFile = PathManager.getUrlFile(Constantes.URL_FILE_PORTFOLIO);
        urlFile  = urlFile.replaceAll("/dist/gfdeploy/P5_2017/P5_2017-war_war/WEB-INF/classes", "/P5_2017-war/src/java");
        
        rwf.readXLSFile(3,urlFile,new Categoria3());
        categoria3Bean.carregarDadosTabelaCategoria3(rwf.getMatrizData());
        UtilMensagensBean.adicionarMensagemDeSucesso("Categorias de nivel 3 Carregada com sucesso");
       
       return "home";  
   }
  
    
}