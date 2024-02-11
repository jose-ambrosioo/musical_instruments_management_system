/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.List;

/**
 *
 * @author julio
 */
public class Operadora 
{
    private String nome;
    private List<Integer> prefixos;

    public Operadora() 
    {
    }

    public Operadora(String nome, List<Integer> prefixos) 
    {
        this.nome = nome;
        this.prefixos = prefixos;
    }

    
    public List<Integer> getPrefixos()
    {
        return prefixos;
    }

    public void setPrefixos(List<Integer> prefixos) 
    {
        this.prefixos = prefixos;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

}
