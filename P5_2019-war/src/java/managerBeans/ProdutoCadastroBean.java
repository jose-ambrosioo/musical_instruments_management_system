/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class ProdutoCadastroBean {

    /**
     * Creates a new instance of ProdutoCadastroBean
     */
    private ProdutoBean produtoBean;
    private Produto produto;
    public ProdutoCadastroBean() 
    {
        produtoBean = (ProdutoBean) GeradorCodigo.getInstanciaBean("produtoBean");
    }

    public Produto getProduto() 
    {
        return produto;
    }

    public void setProduto(Produto produto) 
    {
        this.produto = produto;
    }
    
    
    
}
