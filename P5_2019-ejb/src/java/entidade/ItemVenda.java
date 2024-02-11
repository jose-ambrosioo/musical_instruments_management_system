/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ulisses
 */
@Entity
@Table(name = "item_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByPkItemVenda", query = "SELECT i FROM ItemVenda i WHERE i.pkItemVenda = :pkItemVenda"),
    @NamedQuery(name = "ItemVenda.findByQuantidade", query = "SELECT i FROM ItemVenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemVenda.findBySubtotal", query = "SELECT i FROM ItemVenda i WHERE i.subtotal = :subtotal")})
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_item_venda")
    private Integer pkItemVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Float subtotal;
    @JoinColumn(name = "fk_venda", referencedColumnName = "pk_venda")
    @ManyToOne
    private Venda fkVenda;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto")
    @ManyToOne
    private Produto fkProduto;

    public ItemVenda() {
    }

    public ItemVenda(Integer pkItemVenda) {
        this.pkItemVenda = pkItemVenda;
    }

    public ItemVenda(Integer pkItemVenda, int quantidade) {
        this.pkItemVenda = pkItemVenda;
        this.quantidade = quantidade;
    }

    public Integer getPkItemVenda() {
        return pkItemVenda;
    }

    public void setPkItemVenda(Integer pkItemVenda) {
        this.pkItemVenda = pkItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Venda getFkVenda() {
        return fkVenda;
    }

    public void setFkVenda(Venda fkVenda) {
        this.fkVenda = fkVenda;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkItemVenda != null ? pkItemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.pkItemVenda == null && other.pkItemVenda != null) || (this.pkItemVenda != null && !this.pkItemVenda.equals(other.pkItemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.ItemVenda[ pkItemVenda=" + pkItemVenda + " ]";
    }
    
}
