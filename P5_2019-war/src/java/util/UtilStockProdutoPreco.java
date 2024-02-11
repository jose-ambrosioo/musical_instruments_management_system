/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entidade.Preco;
import entidade.Stock;
import java.util.List;

/**
 *
 * @author julio
 */
public class UtilStockProdutoPreco 
{
    
    private List<Stock> stock;
    private List<Preco> PrecosProduto;

    public List<Stock> getStock() 
    {
        return stock;
    }

    public void setStock(List<Stock> stock) 
    {
        this.stock = stock;
    }

    public List<Preco> getPrecosProduto()
    {
        return PrecosProduto;
    }

    public void setPrecosProduto(List<Preco> PrecosProduto)
    {
        this.PrecosProduto = PrecosProduto;
    }
    
    
    
}