/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ulisses
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByPkVenda", query = "SELECT v FROM Venda v WHERE v.pkVenda = :pkVenda"),
    @NamedQuery(name = "Venda.findByTotalVenda", query = "SELECT v FROM Venda v WHERE v.totalVenda = :totalVenda"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_venda")
    private Integer pkVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_venda")
    private Float totalVenda;
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @OneToMany(mappedBy = "fkVenda")
    private List<ItemVenda> itemVendaList;
    @JoinColumn(name = "fk_forma_pagamento", referencedColumnName = "pk_forma_pagamento")
    @ManyToOne
    private FormaPagamento fkFormaPagamento;
    @JoinColumn(name = "fk_conta", referencedColumnName = "pk_conta")
    @ManyToOne
    private Conta fkConta;

    public Venda() {
    }

    public Venda(Integer pkVenda) {
        this.pkVenda = pkVenda;
    }

    public Integer getPkVenda() {
        return pkVenda;
    }

    public void setPkVenda(Integer pkVenda) {
        this.pkVenda = pkVenda;
    }

    public Float getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Float totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @XmlTransient
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    public FormaPagamento getFkFormaPagamento() {
        return fkFormaPagamento;
    }

    public void setFkFormaPagamento(FormaPagamento fkFormaPagamento) {
        this.fkFormaPagamento = fkFormaPagamento;
    }

    public Conta getFkConta() {
        return fkConta;
    }

    public void setFkConta(Conta fkConta) {
        this.fkConta = fkConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVenda != null ? pkVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.pkVenda == null && other.pkVenda != null) || (this.pkVenda != null && !this.pkVenda.equals(other.pkVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Venda[ pkVenda=" + pkVenda + " ]";
    }
    
}
