/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Produto;
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
public class ProdutofinirQuantidadeMaximaStockBean {

    /**
     * Creates a new instance of ProdutofinirQuantidadeMaximaStockBean
     */
    private ProdutoBean produtoBean;
    private StockBean stockBean;
    private Produto produto;
    private ListDataModel<Produto> listaProdutos;
    public ProdutofinirQuantidadeMaximaStockBean()
    {
        produtoBean = (ProdutoBean) GeradorCodigo.getInstanciaBean("produtoBean");
        stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
        listaProdutos =  findProdutosPorDefinirQuantidadeMaxima();
        produto = new Produto();
    }
    
    public ListDataModel<Produto> findProdutosPorDefinirQuantidadeMaxima()
    {
        return new ListDataModel<Produto>(produtoBean.getProdutoFacade().findAllByQuantidade(0));
    }

    
    public void preparParaDefinir()
    {
        this.produto = listaProdutos.getRowData(); 
    }

    public void definir()
    {
        this.produtoBean.getCategoria3Bean().alterar(produto.getFkCategoria3());
        this.stockBean.cadastrar(produto);
        UtilMensagensBean.adicionarMensagemDeSucesso("Quantidade Maxima definida");
        listaProdutos = findProdutosPorDefinirQuantidadeMaxima();
    }
    
    public Produto getProduto()
    {
        
        return produto;
    }

    public void setProduto(Produto produto) 
    {
        this.produto = produto;
    }

    public ListDataModel<Produto> getListaProdutos()
    {
        setListaProdutos(findProdutosPorDefinirQuantidadeMaxima());
        return listaProdutos;
    }

    public void setListaProdutos(ListDataModel<Produto> listaProdutos) 
    {
        this.listaProdutos = listaProdutos;
    }
    
    
}
