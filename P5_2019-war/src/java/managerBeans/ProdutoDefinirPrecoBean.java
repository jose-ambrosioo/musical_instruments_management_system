/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Preco;
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
public class ProdutoDefinirPrecoBean 
{

    /**
     * Creates a new instance of ProdutoDefinirPrecoBean
     */
    private PrecoBean precoBean;
    private ListDataModel<Preco> listaProdutosPreco;
    private Preco preco;
    
    public ProdutoDefinirPrecoBean()
    {
        inic();
    }
    
    public void inic()
    {
        precoBean = (PrecoBean) GeradorCodigo.getInstanciaBean("precoBean");
        listaProdutosPreco = findAllOrderedByNomeProduto();
        for(Preco preco: listaProdutosPreco)
        {
            System.err.println("Produto : " + preco.getFkProduto().getFkCategoria3().getNome());
            System.err.println("valor do produto : " + preco.getValor());
        }
        preco = new Preco(0);
    }
    
    public ListDataModel<Preco> getListaProdutosPreco() 
    {
        setListaProdutosPreco(findAllOrderedByNomeProduto());
        return listaProdutosPreco;
    }

    public ListDataModel<Preco> findAllOrderedByNomeProduto()
    {
        return new ListDataModel<Preco>(this.precoBean.findAllOrderedByNomeProduto());
    }
    
    public void setListaProdutosPreco(ListDataModel<Preco> listaProdutosPreco)
    {
        this.listaProdutosPreco = listaProdutosPreco;
    }
    
    
    public ListDataModel<Preco> inicializarListaProdutosPreco()
    {
        return new ListDataModel<Preco>();
    }
    
    public void prepararDefinicaoPreco()
    {
        preco = this.listaProdutosPreco.getRowData();
        UtilMensagensBean.adicionarMensagemDeSucesso("Definir preco");
    }
    
    public void definir()
    {
        precoBean.setPreco(preco);
        System.err.println("Valor do produto : " + precoBean.getPreco().getValor());
        precoBean.definir();
        setListaProdutosPreco(findAllOrderedByNomeProduto());
        UtilMensagensBean.adicionarMensagemDeSucesso("preco definido");
        
    }

    public Preco getPreco()
    {
        return preco;
    }

    public void setPreco(Preco preco)
    {
        this.preco = preco;
    }
    
    
}

