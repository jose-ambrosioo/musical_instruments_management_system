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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByPkFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.pkFornecedor = :pkFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_fornecedor")
    private Integer pkFornecedor;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "fkFornecedor")
    private List<Produto> produtoList;

    public Fornecedor() {
    }

    public Fornecedor(Integer pkFornecedor) {
        this.pkFornecedor = pkFornecedor;
    }

    public Integer getPkFornecedor() {
        return pkFornecedor;
    }

    public void setPkFornecedor(Integer pkFornecedor) {
        this.pkFornecedor = pkFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFornecedor != null ? pkFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.pkFornecedor == null && other.pkFornecedor != null) || (this.pkFornecedor != null && !this.pkFornecedor.equals(other.pkFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Fornecedor[ pkFornecedor=" + pkFornecedor + " ]";
    }
    
}
