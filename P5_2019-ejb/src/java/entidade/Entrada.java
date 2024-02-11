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
@Table(name = "entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByQuantidadeMaxima", query = "SELECT e FROM Entrada e WHERE e.quantidadeMaxima = :quantidadeMaxima"),
    @NamedQuery(name = "Entrada.findByQuantidadeDisponivel", query = "SELECT e FROM Entrada e WHERE e.quantidadeDisponivel = :quantidadeDisponivel"),
    @NamedQuery(name = "Entrada.findByDataEntrada", query = "SELECT e FROM Entrada e WHERE e.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Entrada.findByPkEntrada", query = "SELECT e FROM Entrada e WHERE e.pkEntrada = :pkEntrada")})
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "quantidade_maxima")
    private Integer quantidadeMaxima;
    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_entrada")
    private Integer pkEntrada;
    @JoinColumn(name = "fk_stock", referencedColumnName = "pk_stock")
    @ManyToOne
    private Stock fkStock;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto")
    @ManyToOne(optional = false)
    private Produto fkProduto;

    public Entrada() {
    }

    public Entrada(Integer pkEntrada) {
        this.pkEntrada = pkEntrada;
    }

    public Integer getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(Integer quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getPkEntrada() {
        return pkEntrada;
    }

    public void setPkEntrada(Integer pkEntrada) {
        this.pkEntrada = pkEntrada;
    }

    public Stock getFkStock() {
        return fkStock;
    }

    public void setFkStock(Stock fkStock) {
        this.fkStock = fkStock;
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
        hash += (pkEntrada != null ? pkEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.pkEntrada == null && other.pkEntrada != null) || (this.pkEntrada != null && !this.pkEntrada.equals(other.pkEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Entrada[ pkEntrada=" + pkEntrada + " ]";
    }
    
}
