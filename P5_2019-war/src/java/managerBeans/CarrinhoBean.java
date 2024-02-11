/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Preco;
import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.PessoaFacade;
import sessao.PrecoFacade;
import sessao.ProdutoFacade;
import util.SubCarrinho;
import util.UtilControlo;
import util.UtilControlo.Carrinho;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean 
{
    @EJB
    private ProdutoFacade produtoFacade;
    @EJB
    private PrecoFacade precoFacade;

    @EJB
    private PessoaFacade pessoaFacade;

    /**
     * Creates a new instance of CarrinhoBean
     */
    
    private  Carrinho carrinho;
    public ListDataModel<SubCarrinho> subcarrinhos;
    private float valor;
    private float valorTotal;
    public CarrinhoBean() 
    {
      inic(); 
    }
    
    public void inic()
    {
        inicializarSubCarrinhos();
        valorTotal = 0;
    }
    
    public Carrinho getCarrinho()
    {
        return UtilControlo.carrinhoCompra;
    }
    
    public void inicializarSubCarrinhos()
    {
        subcarrinhos = new ListDataModel<SubCarrinho>();
    }
    
    public void carregarDadosNosSubCarrinhos()
    {
        
        List<SubCarrinho> lista = new ArrayList<SubCarrinho>();
        valorTotal = 0;
        for(int i = 0; i< UtilControlo.carrinhoCompra.getSubcarrinhos().size(); ++i)
        {
            int idProduto = UtilControlo.carrinhoCompra.getSubcarrinhos().get(i).getProdutos().getPkProduto();
            int quantidade = UtilControlo.carrinhoCompra.getSubcarrinhos().get(i).quantidade;
            Produto produto = this.produtoFacade.find(idProduto);
            float valorPreco =  this.precoFacade.findPrecoByProduto(produto).getValor();
            float subTotal = quantidade*valorPreco;
            valorTotal += subTotal;
            lista.add(new SubCarrinho(quantidade, produto, quantidade, subTotal));
        }
         
        subcarrinhos = new ListDataModel<SubCarrinho>(lista);
    }
    
//     public void carregarDadosNosSubCarrinhos()
//    {
//        inicializarSubCarrinhos();
//        List<Carrinho> lista = new ArrayList<Carrinho>();
////        for(int i = 0; i< UtilControlo.carrinhoCompra.carrinho.size(); ++i)
////        {
////            int idProduto = UtilControlo.carrinhoCompra.carrinho.get(i);
////            int quantidade = UtilControlo.carrinhoCompra.quantidades.get(i);
////            Produto produto = this.produtoFacade.find(idProduto);
////            float valorPreco =  this.precoFacade.findPrecoByProduto(produto).getValor();
////            float subTotal = quantidade*valorPreco;
////            carrinho.produtos.add(produto);
////            carrinho.quantidades.add(quantidade);
////            carrinho.subtotais.add(subTotal);
////            
////            lista.add(carrinho);
////            carregarDados(lista);
////        }
//    }
    
    public void carregarDados(List<Carrinho> carrinhos)
    {
//        subcarrinhos = new ListDataModel<Carrinho>(carrinhos);
    }
    
    

    public ListDataModel<SubCarrinho> getSubcarrinhos() 
    {
        carregarDadosNosSubCarrinhos();
        return subcarrinhos;
    }

    public void setSubcarrinhos(ListDataModel<SubCarrinho> subcarrinhos) 
    {
        this.subcarrinhos = subcarrinhos;
    }
    
     public float getValor(String idPreco) 
     {
        
      String[]  vetor = idPreco.split("=");
      vetor = vetor[vetor.length -1].split("]");
      String str = vetor[vetor.length-1];
      Integer id = Integer.parseInt(str.trim());
      System.err.println(" tamanhoVetor "+ vetor.length + " valor do IdPreco " +id);
      Preco preco  = this.precoFacade.find(id);
      valor = preco.getValor();
      return valor;

    }

    public void setValor(float valor) 
    {
        this.valor = valor;
    }
    
     
   public void remover()
   {
       
       SubCarrinho subCarrinho = subcarrinhos.getRowData();
       System.err.println("lista do produto antes: " + UtilControlo.carrinhoCompra.subcarrinhos.size());
       try
       {
            for(int i = 0; i <  UtilControlo.carrinhoCompra.getSubcarrinhos().size(); i++ )
            {
                System.err.println( subCarrinho.produto.getPkProduto()+ " = " + UtilControlo.carrinhoCompra.subcarrinhos.get(i).produto.getPkProduto());

                if(subCarrinho.produto.getPkProduto() == UtilControlo.carrinhoCompra.subcarrinhos.get(i).produto.getPkProduto())
                {
                     UtilControlo.carrinhoCompra.subcarrinhos.remove(i);
                     System.err.println("produto removido: " + subCarrinho);
                }
            }
       
            if(UtilControlo.carrinhoCompra.subcarrinhos.equals(null))
                UtilControlo.carrinhoCompra.subcarrinhos = new ArrayList<SubCarrinho>();
            else
            {
                //System.err.println("lista do produto depois: " + UtilControlo.carrinhoCompra.subcarrinhos.size());
                carregarDadosNosSubCarrinhos();
            }
       }
       catch(NullPointerException ex)
       {
           System.err.println(" " + ex.getMessage());
       }
 
   }

    public float getValorTotal() 
    {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) 
    {
        this.valorTotal = valorTotal;
    }

    void excluir(Produto produto) 
    {
        List<SubCarrinho> lista = new ArrayList<SubCarrinho>();
        for(int i = 0; i< UtilControlo.carrinhoCompra.subcarrinhos.size(); i++)
        {
            if(produto.equals(UtilControlo.carrinhoCompra.subcarrinhos.get(i).produto))
            {
                System.err.println(" Produto a eliminar do carrinho : " + produto);
                UtilControlo.carrinhoCompra.subcarrinhos.remove(i);
                System.err.println(" Produto eliminado : " + produto);
                excluir(produto);
            }
            else
              lista.add(UtilControlo.carrinhoCompra.subcarrinhos.get(i));
        }
    }
   
    public void inicializarCarrinhoCompra()
    {
        new UtilControlo().inicializar();
    }
   
}