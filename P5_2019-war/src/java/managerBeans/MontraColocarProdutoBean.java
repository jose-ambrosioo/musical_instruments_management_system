/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Montra;
import entidade.Produto;
import entidade.Stock;
import java.util.ArrayList;
import java.util.List;
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
public class MontraColocarProdutoBean 
{

    /**
     * Creates a new instance of MontraColocarProdutoBean
     */
    private MontraBean montraBean;
    private StockBean stockBean;
    private ListDataModel<Stock> listaStocks;
    private ListDataModel<Stock> listaMontras;
    private ProdutoBean produtoBean;
    private PrecoBean precoBean;
    public MontraColocarProdutoBean()
    {
        inic();
    }
    
    public void inic()
    {
        montraBean = (MontraBean) GeradorCodigo.getInstanciaBean("montraBean");
        stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
        produtoBean = (ProdutoBean) GeradorCodigo.getInstanciaBean("produtoBean");
        precoBean = (PrecoBean)  GeradorCodigo.getInstanciaBean("precoBean");
        listaStocks = findAllStockOrderedByNomeProduto(); 
    }
    
    public ListDataModel<Stock>  findAllStockOrderedByNomeProduto()
    {
        return findAllProdutos();
    }
    
    public ListDataModel<Stock> findAllProdutos()
    {
        List<Stock> lista = new ArrayList<Stock>();
        for(Stock stock : stockBean.findAllProdutoOrderedByNome())
        {
            if(precoBean.getValorProduto(stock.getFkProduto()) > 0 && stock.getQuantidadeDisponivel()>0)
                lista.add(stock);
        }
        
        return new ListDataModel<Stock>(lista);
    }
    
    public ListDataModel<Stock> getListaStocks() 
    {
        setListaStocks(findAllStockOrderedByNomeProduto());
        return listaStocks;
    }
    
    public void cadastrar()
    {
        Stock stock = listaStocks.getRowData();
        System.err.println("id do stock selecionado : " + stock.getFkProduto().getPkProduto());
        if(!produtoExisteMontra((Integer)stock.getFkProduto().getPkProduto()))
        {
            System.err.println("Preco : " + stock.getFkProduto().getPrecoList().get(0).getValor());
            
            montraBean.setStock(stock);
            montraBean.cadastrar(); 
             
        }
        else
        {
            UtilMensagensBean.adicionarMensagemDeSucesso("Este produto ja existe na montra");
        }
    }

    public float getValorProduto(Produto produto)
    {
        return this.precoBean.findPreco(produto).getValor();
    }
    
   public boolean produtoExisteMontra(Integer idProduto)
   {
       return montraBean.findByIdProduto(idProduto) != null;
   }
    public void setListaStocks(ListDataModel<Stock> listaStocks) 
    {
        this.listaStocks = listaStocks;
    }
    
    
}
