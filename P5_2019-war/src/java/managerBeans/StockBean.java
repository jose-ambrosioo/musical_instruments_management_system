/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Montra;
import entidade.Produto;
import entidade.Stock;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.MontraFacade;
import sessao.ProdutoFacade;
import sessao.StockFacade;
import util.UtilStockProdutoPreco;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class StockBean 
{
    @EJB
    private MontraFacade montraFacade;

    @EJB
    private ProdutoFacade produtoFacade;
    @EJB
    private StockFacade stockFacade;

    /**
     * Creates a new instance of stockBean
     */
    
    private ListDataModel<Stock>  listaProdutosStock;
    private Stock stock;
    private int quantidadeMaxima;
    private int novaQuantidade;
    private UtilStockProdutoPreco stokProdutoPreco;
    private Produto produto;
    
    public StockBean() 
    {
        stock = new Stock();
    }

    public ListDataModel<Stock> getListaProdutosStock() 
    {
         listaProdutosStock = inicializarLista();
        
        listaProdutosStock = new ListDataModel<Stock>(this.stockFacade.findAll());
        return listaProdutosStock;
    }

    public void setListaProdutosStock(ListDataModel<Stock> listaProdutosStock) 
    {
        this.listaProdutosStock = listaProdutosStock;
    }

    

    public Stock getStock() 
    {
        return stock;
    }

    public void setStock(Stock stock)
    {
        this.stock = stock;
    }

    public int getQuantidadeMaxima() 
    {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) 
    {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public int getNovaQuantidade() 
    {
        return novaQuantidade;
    }

    public void setNovaQuantidade(int novaQuantidade)
    {
        this.novaQuantidade = novaQuantidade;
    }
    
    public Produto getProduto()
    {
        return produto;
    }

    public void setProduto(Produto produto) 
    {
        this.produto = produto;
    }
    
    public ListDataModel<Stock> inicializarLista()
    {
        return new ListDataModel<Stock>();
    }
    
    public void cadastrar(Produto produto)
    {
        stock.setPkStock(this.stockFacade.getProximoId());
        stock.setFkProduto(produto);
        stock.setQuantidadeMaxima(produto.getFkCategoria3().getQuantidadeMaxima());
        stock.setQuantidadeDisponivel(0);
        this.stockFacade.create(stock);
    }
    
    
    public List<Stock>  findAllProdutoOrderedByNome()
    {
       return  this.stockFacade.findAll();
    }

    public void  excluir()
    {
        
       System.err.println("Objecto a remover : " + stock.toString());
       this.stockFacade.remove(stock);
       UtilMensagensBean.adicionarMensagemDeSucesso("Produto foi excluido do stock");
    }
    
    
    public void alterar()
    {
        this.stockFacade.edit(stock);
    }

    public StockFacade getStockFacade() 
    {
        return stockFacade;
    }

    public void setStockFacade(StockFacade stockFacade) 
    {
        this.stockFacade = stockFacade;
    }
  
    public void alterar(Stock stock)
    {   
        if(stock != null)
            this.stockFacade.edit(stock);
    }
    
    
   public void reduzirQuantidadeStock(Produto produto ,int quantidade)
   {
        Stock st = this.stockFacade.findStockByProduto(produto);
        int novaQuantidade = st.getQuantidadeDisponivel() - quantidade;
        st.setQuantidadeDisponivel(novaQuantidade);
        alterar(st);
   }
}