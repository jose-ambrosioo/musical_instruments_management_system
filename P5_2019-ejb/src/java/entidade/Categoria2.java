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
@Table(name = "categoria2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria2.findAll", query = "SELECT c FROM Categoria2 c"),
    @NamedQuery(name = "Categoria2.findByPkCategoria2", query = "SELECT c FROM Categoria2 c WHERE c.pkCategoria2 = :pkCategoria2"),
    @NamedQuery(name = "Categoria2.findByNome", query = "SELECT c FROM Categoria2 c WHERE c.nome = :nome")})
public class Categoria2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pk_categoria2")
    private String pkCategoria2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "fk_categoria1", referencedColumnName = "pk_categoria1")
    @ManyToOne
    private Categoria1 fkCategoria1;
    @OneToMany(mappedBy = "fkCategoria2")
    private List<Categoria3> categoria3List;

    public Categoria2() {
    }

    public Categoria2(String pkCategoria2) {
        this.pkCategoria2 = pkCategoria2;
    }

    public Categoria2(String pkCategoria2, String nome) {
        this.pkCategoria2 = pkCategoria2;
        this.nome = nome;
    }

    public String getPkCategoria2() {
        return pkCategoria2;
    }

    public void setPkCategoria2(String pkCategoria2) {
        this.pkCategoria2 = pkCategoria2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria1 getFkCategoria1() {
        return fkCategoria1;
    }

    public void setFkCategoria1(Categoria1 fkCategoria1) {
        this.fkCategoria1 = fkCategoria1;
    }

    @XmlTransient
    public List<Categoria3> getCategoria3List() {
        return categoria3List;
    }

    public void setCategoria3List(List<Categoria3> categoria3List) {
        this.categoria3List = categoria3List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCategoria2 != null ? pkCategoria2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria2)) {
            return false;
        }
        Categoria2 other = (Categoria2) object;
        if ((this.pkCategoria2 == null && other.pkCategoria2 != null) || (this.pkCategoria2 != null && !this.pkCategoria2.equals(other.pkCategoria2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Categoria2[ pkCategoria2=" + pkCategoria2 + " ]";
    }
    
}
