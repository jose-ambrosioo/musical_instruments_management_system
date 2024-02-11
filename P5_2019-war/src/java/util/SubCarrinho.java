/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entidade.Produto;

/**
 *
 * @author julio
 */
public class SubCarrinho 
{
    
            public  int subCarrinho;
            public  Produto produto;
            public  int quantidade;
            public  float subtotal;
            
            public SubCarrinho()
            {
                inicializarSubCarrinho();
            }

            public SubCarrinho(int subCarrinho, Produto produto, int quantidade, float subtotal) {
                this.subCarrinho = subCarrinho;
                this.produto = produto;
                this.quantidade = quantidade;
                this.subtotal = subtotal;
            }
                        
            
            public  void inicializarSubCarrinho()
            {
                subCarrinho = 0;
                produto = new Produto();
                quantidade = 0;
                subtotal = 0;
            }

            public int getSubCarrinho() {
                return subCarrinho;
            }

            public void setSubCarrinho(int subCarrinho) {
                this.subCarrinho = subCarrinho;
            }

            public Produto getProdutos() {
                return produto;
            }

            public void setProduto(Produto produto) {
                this.produto = produto;
            }

            public int getQuantidade() {
                return quantidade;
            }

            public void setQuantidade(int quantidades) 
            {
                this.quantidade = quantidade;
            }

            public float getSubtotal()
            {
                return subtotal;
            }

            public void setSubtotal(float subtotal) {
                this.subtotal = subtotal;
            }
    
}