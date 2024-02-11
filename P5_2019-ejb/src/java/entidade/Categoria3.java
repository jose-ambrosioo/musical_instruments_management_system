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
@Table(name = "categoria3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria3.findAll", query = "SELECT c FROM Categoria3 c"),
    @NamedQuery(name = "Categoria3.findByPkCategoria3", query = "SELECT c FROM Categoria3 c WHERE c.pkCategoria3 = :pkCategoria3"),
    @NamedQuery(name = "Categoria3.findByNome", query = "SELECT c FROM Categoria3 c WHERE c.nome = :nome"),
    @NamedQuery(name = "Categoria3.findByQuantidadeMaxima", query = "SELECT c FROM Categoria3 c WHERE c.quantidadeMaxima = :quantidadeMaxima")})
public class Categoria3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pk_categoria3")
    private String pkCategoria3;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade_maxima")
    private Integer quantidadeMaxima;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategoria3")
    private List<Produto> produtoList;
    @JoinColumn(name = "fk_categoria2", referencedColumnName = "pk_categoria2")
    @ManyToOne
    private Categoria2 fkCategoria2;

    public Categoria3() {
    }

    public Categoria3(String pkCategoria3) {
        this.pkCategoria3 = pkCategoria3;
    }

    public String getPkCategoria3() {
        return pkCategoria3;
    }

    public void setPkCategoria3(String pkCategoria3) {
        this.pkCategoria3 = pkCategoria3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(Integer quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Categoria2 getFkCategoria2() {
        return fkCategoria2;
    }

    public void setFkCategoria2(Categoria2 fkCategoria2) {
        this.fkCategoria2 = fkCategoria2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCategoria3 != null ? pkCategoria3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria3)) {
            return false;
        }
        Categoria3 other = (Categoria3) object;
        if ((this.pkCategoria3 == null && other.pkCategoria3 != null) || (this.pkCategoria3 != null && !this.pkCategoria3.equals(other.pkCategoria3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Categoria3[ pkCategoria3=" + pkCategoria3 + " ]";
    }
    
}
