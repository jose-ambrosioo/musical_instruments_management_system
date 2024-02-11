/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.FormaPagamento;
import entidade.Produto;
import entidade.Stock;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import util.GeradorCodigo;
import util.SubCarrinho;
import util.UtilControlo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class CarrinhoCompraBean {

    /**
     * Creates a new instance of CarrinhoCompraBean
     */
    private CarrinhoBean carrinhoBean;
    private ListDataModel<SubCarrinho> itens_carrinho;
    private Stock stock;
    private StockBean stockBean;
    private int quantidadeSolicitada;
    public CarrinhoCompraBean() 
    {
       inic();   
    }
    public void inic()
    {
        carrinhoBean = (CarrinhoBean) GeradorCodigo.getInstanciaBean("carrinhoBean");
        stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
        carrinhoBean.inicializarSubCarrinhos();
        itens_carrinho = carrinhoBean.getSubcarrinhos();
        stock = new Stock(0);
        quantidadeSolicitada = 0;
        
    }
    
    public void adicionarItensCarinho( Produto produto, int quantidadeCliente)
    {
        UtilControlo.carrinhoCompra.adicionarAoCarrinho(produto, quantidadeCliente);
        carrinhoBean.carregarDadosNosSubCarrinhos();
    }

    public ListDataModel<SubCarrinho> getItens_carrinho() 
    {
        setItens_carrinho(carrinhoBean.getSubcarrinhos());
        return itens_carrinho;
    }

    public void setItens_carrinho(ListDataModel<SubCarrinho> itens_carrinho)
    {
        this.itens_carrinho = itens_carrinho;
    }

    public void prepararAlterarQuantidade()
    {
       Produto produto = itens_carrinho.getRowData().getProdutos();
       setStock(stockBean.getStockFacade().findStockByProduto(produto)); 
       quantidadeSolicitada = itens_carrinho.getRowData().quantidade;
      
       System.err.println(" stock : " + stock);
    }
    
    public void alterarQuantidade()
    {
        
    }
    
    public void excluir()
    {
       Produto produto = itens_carrinho.getRowData().getProdutos();
       System.err.println(" tamanho do carrinho antes : " + itens_carrinho.getRowCount());
       carrinhoBean.excluir(produto);
       carrinhoBean.carregarDadosNosSubCarrinhos();
       System.err.println(" tamanho do carrinho depois : " + getItens_carrinho().getRowCount());
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
    
   public void cancelar()
    {
        carrinhoBean.inicializarCarrinhoCompra();
        carrinhoBean.inicializarSubCarrinhos();
        inic();
    }
}
