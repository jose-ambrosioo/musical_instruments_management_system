/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import entidade.Conta;
import entidade.Pessoa;
import entidade.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import util.GeradorCodigo;
import util.Operadora;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class Defesa1Bean 
{

    /**
     * Creates a new instance of Defesa1Bean
     */
    private  ContaBean contaBean;
    private VendaBean vendaBean;
    private PessoaBean pessoaBean;
    private List<Operadora> listaOperadoras;
    private List<String> nomeOperadorasSelected;
    private List<String> apelidosSelected;
    private List<String> dominiosEmaisSelected;
    private String operadora;
    private Date data1, data2;
    private float valor1, valor2;
    public Defesa1Bean() 
    {
        inic();
    }
    
    public void inic()
    {
        contaBean = (ContaBean) GeradorCodigo.getInstanciaBean("contaBean");
        vendaBean = (VendaBean) GeradorCodigo.getInstanciaBean("vendaBean");
        pessoaBean = (PessoaBean) GeradorCodigo.getInstanciaBean("pessoaBean");
        listaOperadoras = new ArrayList<Operadora>();
        nomeOperadorasSelected = new ArrayList<String>();
        dominiosEmaisSelected = new ArrayList<String>();
        apelidosSelected = new ArrayList<String>();
        data1 = new Date();
        data2 = new Date();
        carregarOperadoras();
        valor1 = valor2 = 0;
    }
    
    
    
    //----- Lista de aplidos dos clientes-----------------------------------
    public  List<String> findAllApelidos()
    {
        List<String> lista = new ArrayList<>();
        for(Pessoa pessoa : pessoaBean.findAll())
        {
            String apelido = ultimo(pessoa.getNome()," ");
            lista.add(apelido);
        }
        
        return lista;
    }
    
    //------- Lista de dominios de emais----------------------
    
    public List<String> findAllDominios()
    {
        List<String> lista = new ArrayList<String>();
        for(Pessoa pessoa : pessoaBean.findAll())
        {
            String  dominio = ultimo(pessoa.getEmail(), "@");
            if(!verificarExiste(lista, dominio))
                lista.add(dominio);
        }
        
        return lista;
    }
    
    //-------verificar se existe na lista o conteudo procurado
    public  boolean verificarExiste( List<String> lista, String arg)
    {
        for(String  valor : lista)
        {
            if(valor.equalsIgnoreCase(arg))
                return true;
        }
        
        return false;
    }
    
    //---------- Recuperar a ultima substring que esta entre o parametro str
    // str : parametro a ser dividido
    // arg ; parametro que indica a separacao  que existe na string.
    
    public String ultimo(String str, String arg)
    {
       String[] vetor = str.split(arg);
       return vetor[vetor.length - 1];
    }
    
    
    public void carregarOperadoras()
    {
        List<Integer> prefixos1 = new ArrayList<Integer>(); 
        prefixos1.add(92);
        prefixos1.add(93);
        prefixos1.add(94);
        listaOperadoras.add( new Operadora( "Unitel", prefixos1));
        
        List<Integer> prefixos2 = new ArrayList<Integer>();
        prefixos2.add(91);
        prefixos2.add(99);
        
        listaOperadoras.add( new Operadora( "Movicel", prefixos2));
       
        List<Integer> prefixos3 = new ArrayList<Integer>();
        prefixos2.add(22);
        prefixos2.add(24);
        
        listaOperadoras.add( new Operadora( "Angola Telecom", prefixos3));
    }

    public List<Operadora> getListaOperadoras()
    {
        return listaOperadoras;
    }

    public void setListaOperadoras(List<Operadora> listaOperadoras) 
    {
        this.listaOperadoras = listaOperadoras;
    }

    public List<String> getNomeOperadorasSelected() 
    {
        return nomeOperadorasSelected;
    }

    public void setNomeOperadorasSelected(List<String> nomeOperadorasSelected)
    {
        this.nomeOperadorasSelected = nomeOperadorasSelected;
    }

    public List<String> getApelidosSelected()
    {
        return apelidosSelected;
    }

    public void setApelidosSelected(List<String> apelidosSelected) 
    {
        this.apelidosSelected = apelidosSelected;
    }

   

    public List<String> getDominiosEmaisSelected() 
    {
        return dominiosEmaisSelected;
    }

    public void setDominiosEmaisSelected(List<String> dominiosEmaisSelected) 
    {
        this.dominiosEmaisSelected = dominiosEmaisSelected;
    }

    

    
    public String getOperadora()
    {
        return operadora;
    }

    public void setOperadora(String operadora) 
    {
        this.operadora = operadora;
    }

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2()
    {
        return data2;
    }

    public void setData2(Date data2) 
    {
        this.data2 = data2;
    }


    public float getValor1() 
    {
        return valor1;
    }

    public void setValor1(float valor1) 
    {
        this.valor1 = valor1;
    }

    public float getValor2() 
    {
        return valor2;
    }

    public void setValor2(float valor2) 
    {
        this.valor2 = valor2;
    }
    
    public void pesquisar()
    {
        
        System.err.println("Operadoras : " + nomeOperadorasSelected);
        System.err.println("Dominios : " + dominiosEmaisSelected);
        System.err.println("apelidos : " + apelidosSelected);
        System.err.println("Data 1 : " + data1);
        System.err.println("Data 2: " + data2);
        System.err.println("valor 1: " + valor1);
        System.err.println("valor 2: " + valor2);
        
        
//        List<Venda> lista = this.vendaBean.getVendaFacade().findDefesa(nomeOperadorasSelected, dominiosEmaisSelected, apelidosSelected, data1, data2, valor1, valor2);

    }
}
