/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.GeradorCodigo;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class Itens_Carrinho 
{

    /**
     * Creates a new instance of Itens_Carrinho
     */
    private CarrinhoBean carrinhoBean;
    public Itens_Carrinho()
    {
        
    }
    
    public void inic()
    {
       carrinhoBean = (CarrinhoBean) GeradorCodigo.getInstanciaBean("carrinhoBean");
    }
    
    
    
 
}
