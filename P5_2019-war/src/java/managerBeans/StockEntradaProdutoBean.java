/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Produto;
import entidade.Stock;
import java.util.List;
import javax.ejb.EJBException;
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
public class StockEntradaProdutoBean 
{

    /**
     * Creates a new instance of StockEntradaProdutoBean
     */
    private StockBean stockBean;
    private ListDataModel<Stock> listaProdutoStock;
    private Stock stock;
    private int novaQuantidade;
    private ProdutoBean produtoBean;
    public StockEntradaProdutoBean()
    {
       inic();
    }

    public void inic()
    {
       stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
       produtoBean = (ProdutoBean)GeradorCodigo.getInstanciaBean("produtoBean");
       listaProdutoStock  = findAllProdutoOrderedByNome();
       stock = new Stock(); 
    }
    
    public ListDataModel<Stock> inicializarLista()
    {
        return  new ListDataModel<Stock>();
    }
    
    public ListDataModel<Stock> findAllProdutoOrderedByNome()
    {
        return  new ListDataModel<Stock>(stockBean.findAllProdutoOrderedByNome());
    }
    
    public ListDataModel<Stock> getListaProdutoStock() 
    {
        this.listaProdutoStock = inicializarLista();
        listaProdutoStock = findAllProdutoOrderedByNome();
        System.err.println(" getListar :  " + listaProdutoStock.getRowCount());
        return listaProdutoStock;
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

    public int getNovaQuantidade() 
    {
        return novaQuantidade;
    }

    public void setNovaQuantidade(int novaQuantidade)
    {
        this.novaQuantidade = novaQuantidade;
    }
    
    public void prepararParaAdicionarQuantidadeProdutoStock()
    {
        stock = listaProdutoStock.getRowData();
        UtilMensagensBean.adicionarMensagemDeSucesso("Dar entrada de produtos no armazem");
    }
     
    public void adionarQuantidadeProdutoStock()
    {
        Integer quantidadeTotal = stock.getQuantidadeDisponivel() + novaQuantidade;
        if(stock.getQuantidadeMaxima()>= quantidadeTotal)
        {
            this.stock.setQuantidadeDisponivel(quantidadeTotal);
            this.stockBean.setStock(stock);
            this.stockBean.alterar();
        }
        else
            UtilMensagensBean.adicionarMensagemDeErro("Erro:  A quantidade a ser disponivel nao pode ser maior \n que a quantidade maxima do produto em stock");
    }
    
    
   
    public void carregarDados()
    {
       for(Produto produto : produtoBean.getProdutoFacade().findAll())
       {
           if(produto.getFkCategoria3().getQuantidadeMaxima() > 0)
           {
              this.stockBean.cadastrar(produto);
           }
       }
    }
    

}
