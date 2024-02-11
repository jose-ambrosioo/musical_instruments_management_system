/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "forma_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f"),
    @NamedQuery(name = "FormaPagamento.findByPkFormaPagamento", query = "SELECT f FROM FormaPagamento f WHERE f.pkFormaPagamento = :pkFormaPagamento"),
    @NamedQuery(name = "FormaPagamento.findByDescricao", query = "SELECT f FROM FormaPagamento f WHERE f.descricao = :descricao")})
public class FormaPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_forma_pagamento")
    private Integer pkFormaPagamento;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "fkFormaPagamento")
    private List<Venda> vendaList;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer pkFormaPagamento) {
        this.pkFormaPagamento = pkFormaPagamento;
    }

    public Integer getPkFormaPagamento() {
        return pkFormaPagamento;
    }

    public void setPkFormaPagamento(Integer pkFormaPagamento) {
        this.pkFormaPagamento = pkFormaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFormaPagamento != null ? pkFormaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.pkFormaPagamento == null && other.pkFormaPagamento != null) || (this.pkFormaPagamento != null && !this.pkFormaPagamento.equals(other.pkFormaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FormaPagamento[ pkFormaPagamento=" + pkFormaPagamento + " ]";
    }
    
}
