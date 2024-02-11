/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ulisses
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPkProduto", query = "SELECT p FROM Produto p WHERE p.pkProduto = :pkProduto"),
    @NamedQuery(name = "Produto.findByImagem", query = "SELECT p FROM Produto p WHERE p.imagem = :imagem")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_produto")
    private Integer pkProduto;
    @Size(max = 100)
    @Column(name = "imagem")
    private String imagem;
    @OneToMany(mappedBy = "fkProduto")
    private List<Preco> precoList;
    @JoinColumn(name = "fk_fornecedor", referencedColumnName = "pk_fornecedor")
    @ManyToOne
    private Fornecedor fkFornecedor;
    @JoinColumn(name = "fk_categoria3", referencedColumnName = "pk_categoria3")
    @ManyToOne(optional = false)
    private Categoria3 fkCategoria3;
    @OneToMany(mappedBy = "fkProduto")
    private List<HistoricoPrecoProduto> historicoPrecoProdutoList;
    @OneToMany(mappedBy = "fkProduto")
    private List<Stock> stockList;
    @OneToMany(mappedBy = "fkProduto")
    private List<ItemVenda> itemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private List<Entrada> entradaList;
    @OneToMany(mappedBy = "fkProduto")
    private List<Montra> montraList;

    public Produto() {
    }

    public Produto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public Integer getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @XmlTransient
    public List<Preco> getPrecoList() {
        return precoList;
    }

    public void setPrecoList(List<Preco> precoList) {
        this.precoList = precoList;
    }

    public Fornecedor getFkFornecedor() {
        return fkFornecedor;
    }

    public void setFkFornecedor(Fornecedor fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
    }

    public Categoria3 getFkCategoria3() {
        return fkCategoria3;
    }

    public void setFkCategoria3(Categoria3 fkCategoria3) {
        this.fkCategoria3 = fkCategoria3;
    }

    @XmlTransient
    public List<HistoricoPrecoProduto> getHistoricoPrecoProdutoList() {
        return historicoPrecoProdutoList;
    }

    public void setHistoricoPrecoProdutoList(List<HistoricoPrecoProduto> historicoPrecoProdutoList) {
        this.historicoPrecoProdutoList = historicoPrecoProdutoList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    @XmlTransient
    public List<Montra> getMontraList() {
        return montraList;
    }

    public void setMontraList(List<Montra> montraList) {
        this.montraList = montraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProduto != null ? pkProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.pkProduto == null && other.pkProduto != null) || (this.pkProduto != null && !this.pkProduto.equals(other.pkProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Produto[ pkProduto=" + pkProduto + " ]";
    }
    
}
