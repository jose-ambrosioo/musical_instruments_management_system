/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Montra;
import entidade.Produto;
import entidade.Stock;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class MontraVisualizarBean {

    /**
     * Creates a new instance of MontraVisualizarBean
     */
    private MontraBean montraBean;
    private StockBean stockBean;
    private ListDataModel<Montra> listaMontras;
    private Stock stock;
    private int quantidadeSolicitada;
    public MontraVisualizarBean() 
    {
        inic();
    }
    
    public void inic()
    {
        montraBean = (MontraBean) GeradorCodigo.getInstanciaBean("montraBean");
        stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
        stock = new Stock(0);
        quantidadeSolicitada = 0;
    }
    
    public ListDataModel<Montra>  findAllProdutoOrderedByNome()
    {
        return new ListDataModel<Montra>(montraBean.findAllOrderedByNome());
    }

    public ListDataModel<Montra> getListaMontras() 
    {
        setListaMontras(findAllProdutoOrderedByNome());
        return listaMontras;
    }

    public void setListaMontras(ListDataModel<Montra> listaMontras)
    {
        this.listaMontras = listaMontras;
    }
    
    public void consultarProdutoStock()
    {
        Produto produto = listaMontras.getRowData().getFkProduto();
        stock = this.stockBean.getStockFacade().findStockByProduto(produto);

        UtilMensagensBean.adicionarMensagemDeSucesso("Definir quantidade para o cliente");
    }

    public Stock getStock() 
    {
        return stock;
    }

    public void setStock(Stock stock) 
    {
        this.stock = stock;
    }

    public int getQuantidadeSolicitada() 
    {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) 
    {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }
   
    public void excluir()
    {
        Montra montra = listaMontras.getRowData();
        montraBean.setMontra(montra);
        montraBean.excluir();
        
    }
    
}
