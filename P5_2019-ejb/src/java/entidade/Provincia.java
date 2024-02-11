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
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByPkProvincia", query = "SELECT p FROM Provincia p WHERE p.pkProvincia = :pkProvincia"),
    @NamedQuery(name = "Provincia.findByNome", query = "SELECT p FROM Provincia p WHERE p.nome = :nome")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_provincia")
    private Integer pkProvincia;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "fk_pais", referencedColumnName = "pk_pais")
    @ManyToOne(optional = false)
    private Pais fkPais;
    @OneToMany(mappedBy = "fkProvincia")
    private List<Municipio> municipioList;

    public Provincia() {
    }

    public Provincia(Integer pkProvincia) {
        this.pkProvincia = pkProvincia;
    }

    public Integer getPkProvincia() {
        return pkProvincia;
    }

    public void setPkProvincia(Integer pkProvincia) {
        this.pkProvincia = pkProvincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getFkPais() {
        return fkPais;
    }

    public void setFkPais(Pais fkPais) {
        this.fkPais = fkPais;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProvincia != null ? pkProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.pkProvincia == null && other.pkProvincia != null) || (this.pkProvincia != null && !this.pkProvincia.equals(other.pkProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Provincia[ pkProvincia=" + pkProvincia + " ]";
    }
    
}
