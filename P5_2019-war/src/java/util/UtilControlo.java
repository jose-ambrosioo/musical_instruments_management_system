/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class UtilControlo 
{
    
    public static Carrinho carrinhoCompra;
    public static Carrinho carroAux;
    
    public  UtilControlo()
    {
         inicializar();
    }
    
    public void inicializar()
    {
        carroAux = new Carrinho();
        carrinhoCompra = new Carrinho();
    }
    public  class Carrinho
    {
        public List<SubCarrinho> subcarrinhos;
        public  float totalVenda =  0;

         
        public Carrinho() 
        {
            subcarrinhos = new ArrayList<SubCarrinho>();
            totalVenda = 0;
        }
        
        public  boolean adicionarAoCarrinho( Produto produto,int quantidade)
        {
            if(!jaExiste ( produto ))
            {
                SubCarrinho subCarrinho = new SubCarrinho();
                subCarrinho.produto = produto;
                subCarrinho.quantidade = quantidade;
                subcarrinhos.add(subCarrinho);
                
                return true;
            }
            else 
                JOptionPane.showMessageDialog (null, "Pruduto ja foi adicionado");
            return false;
        }
        
        public  boolean jaExiste(Produto produto)
        {
            for(int i=0; i< subcarrinhos.size (); i++)
            {
                if (subcarrinhos.get(i).produto.equals(produto))
                    return true;
            }
            return false;
            
        }

        public float getTotalVenda() 
        {
            return totalVenda;
        }

        public void setTotalVenda(float totalVenda) 
        {
            this.totalVenda = totalVenda;
        }

        public List<SubCarrinho> getSubcarrinhos() 
        {
            return subcarrinhos;
        }

        public void setSubcarrinhos(List<SubCarrinho> subcarrinhos) 
        {
            this.subcarrinhos = subcarrinhos;
        }
   
        
//        public String getElmentos()
//        {
//            String elementos = "";
//            for(int i=0; i< subcarrinhos.size (); i++)
//            {
//                elementos = elementos + " - " + carrinho.get ( i );
//            }
//            
//            return elementos;
//        }

//        public  ArrayList<Integer> getCarrinho()
//        {
//            return subcarrinhos;
//        }
//  
     
    }
    
     
}