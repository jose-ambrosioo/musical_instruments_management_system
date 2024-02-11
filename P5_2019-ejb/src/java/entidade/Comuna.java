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
@Table(name = "comuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByPkComuna", query = "SELECT c FROM Comuna c WHERE c.pkComuna = :pkComuna"),
    @NamedQuery(name = "Comuna.findByNome", query = "SELECT c FROM Comuna c WHERE c.nome = :nome")})
public class Comuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_comuna")
    private Integer pkComuna;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "fk_municipio", referencedColumnName = "pk_municipio")
    @ManyToOne(optional = false)
    private Municipio fkMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkComuna")
    private List<Endereco> enderecoList;

    public Comuna() {
    }

    public Comuna(Integer pkComuna) {
        this.pkComuna = pkComuna;
    }

    public Integer getPkComuna() {
        return pkComuna;
    }

    public void setPkComuna(Integer pkComuna) {
        this.pkComuna = pkComuna;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Municipio getFkMunicipio() {
        return fkMunicipio;
    }

    public void setFkMunicipio(Municipio fkMunicipio) {
        this.fkMunicipio = fkMunicipio;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkComuna != null ? pkComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.pkComuna == null && other.pkComuna != null) || (this.pkComuna != null && !this.pkComuna.equals(other.pkComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Comuna[ pkComuna=" + pkComuna + " ]";
    }
    
}
