/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

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
public class StockProdutoListaBean 
{

    /**
     * Creates a new instance of StockProdutoListaBean
     */
    private StockBean stockBean;
    private ListDataModel<Stock> listaProdutoStock;
    private Stock stock;
    public StockProdutoListaBean() 
    {
        inic();
    }
    
    
    public void inic()
    {
       stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
       listaProdutoStock  = findAllProdutoOrderedByNome();
       stock = new Stock(); 
    }
    
    public ListDataModel<Stock> findAllProdutoOrderedByNome()
    {
        return  new ListDataModel<Stock>(stockBean.findAllProdutoOrderedByNome());
    }
   
    public ListDataModel<Stock> getListaProdutoStock() 
    {

        setListaProdutoStock(findAllProdutoOrderedByNome());
        System.err.println(" getListar :  " + listaProdutoStock.getRowCount());
        return listaProdutoStock;
    }
    
    public void excluir()
    {
        stock = listaProdutoStock.getRowData();
        this.stockBean.setStock(stock);
        this.stockBean.excluir();
    }
    
    public ListDataModel<Stock> inicializarLista()
    {
        return  new ListDataModel<Stock>();
    }
    
    public void setListaProdutoStock(ListDataModel<Stock> listaProdutoStock) 
    {
        this.listaProdutoStock = listaProdutoStock;
    }

    public Stock getStock() 
    {
        return stock;
    }

    public void setStock(Stock stock)
    {
        this.stock = stock;
    }
    
}
