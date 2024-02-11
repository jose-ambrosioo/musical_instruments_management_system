/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ulisses
 */
@Entity
@Table(name = "historico_preco_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoPrecoProduto.findAll", query = "SELECT h FROM HistoricoPrecoProduto h"),
    @NamedQuery(name = "HistoricoPrecoProduto.findByPkHistoricoPrecoProduto", query = "SELECT h FROM HistoricoPrecoProduto h WHERE h.pkHistoricoPrecoProduto = :pkHistoricoPrecoProduto"),
    @NamedQuery(name = "HistoricoPrecoProduto.findByValor", query = "SELECT h FROM HistoricoPrecoProduto h WHERE h.valor = :valor"),
    @NamedQuery(name = "HistoricoPrecoProduto.findByDataCadastro", query = "SELECT h FROM HistoricoPrecoProduto h WHERE h.dataCadastro = :dataCadastro")})
public class HistoricoPrecoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_historico_preco_produto")
    private Integer pkHistoricoPrecoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private float valor;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto")
    @ManyToOne
    private Produto fkProduto;

    public HistoricoPrecoProduto() {
    }

    public HistoricoPrecoProduto(Integer pkHistoricoPrecoProduto) {
        this.pkHistoricoPrecoProduto = pkHistoricoPrecoProduto;
    }

    public HistoricoPrecoProduto(Integer pkHistoricoPrecoProduto, float valor) {
        this.pkHistoricoPrecoProduto = pkHistoricoPrecoProduto;
        this.valor = valor;
    }

    public Integer getPkHistoricoPrecoProduto() {
        return pkHistoricoPrecoProduto;
    }

    public void setPkHistoricoPrecoProduto(Integer pkHistoricoPrecoProduto) {
        this.pkHistoricoPrecoProduto = pkHistoricoPrecoProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        hash += (pkHistoricoPrecoProduto != null ? pkHistoricoPrecoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPrecoProduto)) {
            return false;
        }
        HistoricoPrecoProduto other = (HistoricoPrecoProduto) object;
        if ((this.pkHistoricoPrecoProduto == null && other.pkHistoricoPrecoProduto != null) || (this.pkHistoricoPrecoProduto != null && !this.pkHistoricoPrecoProduto.equals(other.pkHistoricoPrecoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.HistoricoPrecoProduto[ pkHistoricoPrecoProduto=" + pkHistoricoPrecoProduto + " ]";
    }
    
}
