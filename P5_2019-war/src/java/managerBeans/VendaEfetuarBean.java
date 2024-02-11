/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.FormaPagamento;
import entidade.ItemVenda;
import entidade.Produto;
import entidade.Venda;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.DataUtils;
import util.GeradorCodigo;
import util.SubCarrinho;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class VendaEfetuarBean 
{

    private FormaPagamento formaPagamento;
    private float totalVenda;
    private CarrinhoBean carrinhoBean;
    private ItemVendaBean itemVendaBean;
    private VendaBean vendaBean;
    private Venda venda;
    private AutenticacaoBean autenticacaoBean;
    private StockBean stockBean;
    private FormaPagamentoBean formaPagamentoBean;
    private CarrinhoCompraBean carrinhoCompraBean;
    public VendaEfetuarBean() 
    {
      inic();
      
    }
    
    public void inic()
    {
        carrinhoBean = (CarrinhoBean) GeradorCodigo.getInstanciaBean("carrinhoBean");
        itemVendaBean = (ItemVendaBean) GeradorCodigo.getInstanciaBean("itemVendaBean");
        vendaBean = (VendaBean) GeradorCodigo.getInstanciaBean("vendaBean");
        autenticacaoBean = (AutenticacaoBean) GeradorCodigo.getInstanciaBean("autenticacaoBean");
        stockBean = (StockBean) GeradorCodigo.getInstanciaBean("stockBean");
        formaPagamentoBean = (FormaPagamentoBean) GeradorCodigo.getInstanciaBean("formaPagamentoBean");
        carrinhoCompraBean = (CarrinhoCompraBean) GeradorCodigo.getInstanciaBean("carrinhoCompraBean");
        formaPagamento  = new FormaPagamento(0);
        totalVenda = carrinhoBean.getValorTotal();
        venda = new Venda(0);
    }
    
    public FormaPagamento getFormaPagamento() 
    {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) 
    {
        this.formaPagamento = formaPagamento;
    }

    public float getTotalVenda() 
    {
        totalVenda = carrinhoBean.getValorTotal();
        return totalVenda;
    }

    public void setTotalVenda(float totalVenda) 
    {
        this.totalVenda = totalVenda;
    }
    
    public void vender()
    {
        venda = new Venda(vendaBean.getVendaFacade().getProximoId());
        venda.setTotalVenda(totalVenda);
        venda.setFkConta(autenticacaoBean.getConta());       
        venda.setDataVenda(DataUtils.getDataCadastro());
        System.err.println(autenticacaoBean.getConta());
        venda.setFkFormaPagamento(this.formaPagamentoBean.getFormaPagamentoFacade().find(formaPagamento.getPkFormaPagamento()));
        vendaBean.cadastrar(venda);
        cadastrarItens(venda);
        carrinhoBean.inic();
        inic();
    }
    
    public void cadastrarItens(Venda venda)
    {
        for(SubCarrinho subCarrinho : carrinhoBean.getSubcarrinhos())
        {
            ItemVenda item = new ItemVenda(itemVendaBean.getItemVendaFacade().getProximoId());
            item.setFkProduto(subCarrinho.produto);
            item.setFkVenda(venda);
            item.setQuantidade(subCarrinho.getQuantidade());
            item.setSubtotal(subCarrinho.getSubtotal());
            
            itemVendaBean.getItemVendaFacade().create(item);
            System.err.println("quantidade : " + subCarrinho.getQuantidade());
            stockBean.reduzirQuantidadeStock(subCarrinho.produto ,subCarrinho.getQuantidade());
        }
    }
    
   
    

}
