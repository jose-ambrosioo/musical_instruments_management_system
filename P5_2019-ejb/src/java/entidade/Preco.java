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
@Table(name = "preco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preco.findAll", query = "SELECT p FROM Preco p"),
    @NamedQuery(name = "Preco.findByPkPreco", query = "SELECT p FROM Preco p WHERE p.pkPreco = :pkPreco"),
    @NamedQuery(name = "Preco.findByValor", query = "SELECT p FROM Preco p WHERE p.valor = :valor"),
    @NamedQuery(name = "Preco.findByDataCadastro", query = "SELECT p FROM Preco p WHERE p.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Preco.findByDataAtualizacao", query = "SELECT p FROM Preco p WHERE p.dataAtualizacao = :dataAtualizacao")})
public class Preco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_preco")
    private Integer pkPreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto")
    @ManyToOne
    private Produto fkProduto;

    public Preco() {
    }

    public Preco(Integer pkPreco) {
        this.pkPreco = pkPreco;
    }

    public Integer getPkPreco() {
        return pkPreco;
    }

    public void setPkPreco(Integer pkPreco) {
        this.pkPreco = pkPreco;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
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
        hash += (pkPreco != null ? pkPreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preco)) {
            return false;
        }
        Preco other = (Preco) object;
        if ((this.pkPreco == null && other.pkPreco != null) || (this.pkPreco != null && !this.pkPreco.equals(other.pkPreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Preco[ pkPreco=" + pkPreco + " ]";
    }
    
}
