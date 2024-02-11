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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPkPerfil", query = "SELECT p FROM Perfil p WHERE p.pkPerfil = :pkPerfil"),
    @NamedQuery(name = "Perfil.findByNome", query = "SELECT p FROM Perfil p WHERE p.nome = :nome")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_perfil")
    private Integer pkPerfil;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "fkPerfil")
    private List<Conta> contaList;

    public Perfil() {
    }

    public Perfil(Integer pkPerfil) {
        this.pkPerfil = pkPerfil;
    }

    public Integer getPkPerfil() {
        return pkPerfil;
    }

    public void setPkPerfil(Integer pkPerfil) {
        this.pkPerfil = pkPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPerfil != null ? pkPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.pkPerfil == null && other.pkPerfil != null) || (this.pkPerfil != null && !this.pkPerfil.equals(other.pkPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Perfil[ pkPerfil=" + pkPerfil + " ]";
    }
    
}
