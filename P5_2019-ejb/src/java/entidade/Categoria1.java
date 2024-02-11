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
@Table(name = "categoria1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria1.findAll", query = "SELECT c FROM Categoria1 c"),
    @NamedQuery(name = "Categoria1.findByPkCategoria1", query = "SELECT c FROM Categoria1 c WHERE c.pkCategoria1 = :pkCategoria1"),
    @NamedQuery(name = "Categoria1.findByNome", query = "SELECT c FROM Categoria1 c WHERE c.nome = :nome")})
public class Categoria1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pk_categoria1")
    private String pkCategoria1;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "fkCategoria1")
    private List<Categoria2> categoria2List;

    public Categoria1() {
    }

    public Categoria1(String pkCategoria1) {
        this.pkCategoria1 = pkCategoria1;
    }

    public String getPkCategoria1() {
        return pkCategoria1;
    }

    public void setPkCategoria1(String pkCategoria1) {
        this.pkCategoria1 = pkCategoria1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Categoria2> getCategoria2List() {
        return categoria2List;
    }

    public void setCategoria2List(List<Categoria2> categoria2List) {
        this.categoria2List = categoria2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCategoria1 != null ? pkCategoria1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria1)) {
            return false;
        }
        Categoria1 other = (Categoria1) object;
        if ((this.pkCategoria1 == null && other.pkCategoria1 != null) || (this.pkCategoria1 != null && !this.pkCategoria1.equals(other.pkCategoria1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Categoria1[ pkCategoria1=" + pkCategoria1 + " ]";
    }
    
}
