/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Categoria3;
import entidade.Preco;
import entidade.Produto;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.ProdutoFacade;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ProdutoBean 
{
    @EJB
    private ProdutoFacade produtoFacade;

    /**
     * Creates a new instance of ProdutoBean
     */
    private Produto produto;
    private Categoria3Bean categoria3Bean;
    private PrecoBean precoBean;
    public ProdutoBean() 
    {
        categoria3Bean = (Categoria3Bean) GeradorCodigo.getInstanciaBean("categoria3Bean");
        precoBean = (PrecoBean) GeradorCodigo.getInstanciaBean("precoBean");
    }

    public ProdutoFacade getProdutoFacade()
    {
        return produtoFacade;
    }

    public void setProdutoFacade(ProdutoFacade produtoFacade) 
    {
        this.produtoFacade = produtoFacade;
    }
    
    public void carregarDados()
    {
       for(Categoria3 categoria3  : categoria3Bean.getCategoria3Facade().findAll())
       {
//           Produto produto = produtoFacade.findByCategoria3(categoria3);
//           if(produto == null)
//           {  
               Produto produto = new Produto(this.produtoFacade.getProximoId());
               
               produto.setFkCategoria3(categoria3);
               this.produtoFacade.create(produto);
               
               Preco preco = new Preco(produto.getPkProduto());
               preco.setValor((float)0);
               preco.setFkProduto(produto);
               precoBean.setPreco(preco);
               
               precoBean.cadastrar();
               
               
//           }
//           else 
//           {
//                produto.setFkCategoria3(categoria3);
//                this.produtoFacade.edit(produto);
//           }
       }
    }

    public Categoria3Bean getCategoria3Bean() 
    {
        return categoria3Bean;
    }

    public void setCategoria3Bean(Categoria3Bean categoria3Bean) 
    {
        this.categoria3Bean = categoria3Bean;
    }

    
       
}
