/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Preco;
import entidade.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.PrecoFacade;
import util.DataUtils;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class PrecoBean 
{

   @EJB
    private PrecoFacade precoFacade;

    /**
     * Creates a new instance of PrecoBean
     */
    private Preco preco;
    private int idPreco;
   
    public PrecoBean() 
    {
        preco = new Preco();
    }

    public int getIdPreco() {
        return idPreco;
    }

    public void setIdPreco(int idPreco) {
        this.idPreco = idPreco;
    }

    public List<Preco> findAllOrderedByNomeProduto()
    {
        return this.precoFacade.findAllOrderedByNomeProduto();
    }

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }
     
    public void definir()
    {
        preco.setDataCadastro(DataUtils.getDataCadastro());
        this.precoFacade.edit(preco);
        UtilMensagensBean.adicionarMensagemDeSucesso("Preco definido com sucesso");
    }
    
    
    
    public void cadastrar()
    {
        this.precoFacade.create(preco);
    }
    
    
    public Preco findPreco(Produto produto)
    {
       return this.precoFacade.findPrecoByProduto(produto);
    }
    
    public float getValorProduto(Produto produto)
    {
        return this.findPreco(produto).getValor();
    }
    
    public float findValorByPreco(Object IdPreco)
    {
        System.err.println(" valor do IdPreco" + idPreco);
//        preco = this.precoFacade.find(idPreco);
//        return preco.getValor();
        return 1;
    }
    
}