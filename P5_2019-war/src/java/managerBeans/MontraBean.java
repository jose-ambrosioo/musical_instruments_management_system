/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Montra;
import entidade.Preco;
import entidade.Produto;
import entidade.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.MontraFacade;
import sessao.PrecoFacade;
import sessao.StockFacade;
import util.SubCarrinho;
import util.UtilControlo;
import util.UtilControlo.Carrinho;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class MontraBean
{
    @EJB
    private StockFacade stockFacade;
    @EJB
    private PrecoFacade precoFacade;
    @EJB
    private MontraFacade montraFacade;

    /**
     * Creates a new instance of MontraBean
     */
    
    private List<Montra> listaProdutosMontra;
    private Preco preco;
    private float valor = 0 ;
    private Stock stock;
    private int quantidadeSolicitada = 0;
    private ArrayList<Integer> listaIdProdutos = new ArrayList<Integer>();
    private ArrayList<Integer> quantidadesSolicitadasProduto = new ArrayList<Integer>();
    private ArrayList<SubCarrinho> subcarrinhos = new ArrayList<SubCarrinho>();
    private SubCarrinho subcarrinho;
    UtilControlo controlo  = new UtilControlo();
    private Montra montra;
    public MontraBean()
    {
        inic();
    }

    public void inic()
    {
        stock = new Stock();
        montra = new Montra();
    }
    
    public List<Montra>  findAllOrderedByNome()
    {
        return this.montraFacade.findAllOrderedByNome();
    }
    
    
    public void cadastrar()
    {
        Montra montra = new Montra(this.montraFacade.getProximoId());
        montra.setFkProduto(stock.getFkProduto());
        this.montraFacade.create(montra);
        UtilMensagensBean.adicionarMensagemDeSucesso("Produto inserido na montra");
    }


   public Montra findByIdProduto(Integer idProduto)
   {
       return this.montraFacade.findByProduto(idProduto);
   }
    
  
   

//   public void adionarProdutoCarrinho()
//   {
//       System.err.println("Quantidade solicitada :" + quantidadeSolicitada);
//       if(quantidadeSolicitada > produtoStock.getQuantidadeDisponivel())
//       {     
//           UtilMensagensBean.adicionarMensagemDeErro("Operacao nao realizada!!! A quantidade solicitada deve ser inferior a quantidade em stock");
//       }
//       else
//       {
//           int idProdutoSelect = produtoStock.getFkProduto().getPkProduto();
//           if(!verificarProdutoExisteCarrinho(idProdutoSelect))
//           {
//              listaIdProdutos.add(idProdutoSelect);
//              quantidadesSolicitadasProduto.add(quantidadeSolicitada);
//              Produto produto = produtoStock.getFkProduto();
//              subcarrinhos.add(new SubCarrinho(idProdutoSelect, produto, quantidadeSolicitada, valor));
//                      
//              UtilControlo.carrinhoCompra.setSubcarrinhos(subcarrinhos);
//              System.err.println("lista de subcarrinhos : " + subcarrinhos.size());
//           }
//           
//           System.err.println("Numero de produtos inseridos no carrinho :" + UtilControlo.carrinhoCompra.getSubcarrinhos().size());
//   
//          UtilMensagensBean.adicionarMensagemDeSucesso("Quantidade Confirmada");
//      }
//  
//   }
//   
   public boolean verificarProdutoExisteCarrinho(int id)
   {
       for(Integer idProduto : listaIdProdutos)
           if(id == idProduto) return true;
       return false;
   }
   public void excluir()
   {
       this.montraFacade.remove(montra);
       UtilMensagensBean.adicionarMensagemDeSucesso("Produto removido da montra com sucesso");
       
   }
   
    public Stock getStock() 
    {
        return stock;
    }

    public void setStock(Stock stock)
    {
        this.stock = stock;
    }
    
    
    public Preco getPreco() 
    {
        
        return preco;
    }

    public void setPreco(Preco preco) 
    {
        this.preco = preco;
    }

    public float getValor(String idPreco) 
    {
      String[]  vetor = idPreco.split("=");
      vetor = vetor[vetor.length -1].split("]");
      String str = vetor[vetor.length-1];
      Integer id = Integer.parseInt(str.trim());
      System.err.println(" tamanhoVetor "+ vetor.length + " valor do IdPreco " + id);
      preco  = this.precoFacade.find(id);
      valor = preco.getValor();
      return valor;
    }

    public void setValor(float valor) 
    {
        this.valor = valor;
    }

    public int getQuantidadeSolicitada() 
    {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) 
    {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Montra getMontra() 
    {
        return montra;
    }

    public void setMontra(Montra montra) 
    {
        this.montra = montra;
    }

    
}