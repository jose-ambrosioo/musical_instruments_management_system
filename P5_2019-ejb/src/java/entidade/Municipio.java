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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByPkMunicipio", query = "SELECT m FROM Municipio m WHERE m.pkMunicipio = :pkMunicipio"),
    @NamedQuery(name = "Municipio.findByNome", query = "SELECT m FROM Municipio m WHERE m.nome = :nome")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_municipio")
    private Integer pkMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMunicipio")
    private List<Comuna> comunaList;
    @JoinColumn(name = "fk_provincia", referencedColumnName = "pk_provincia")
    @ManyToOne
    private Provincia fkProvincia;

    public Municipio() {
    }

    public Municipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public Municipio(Integer pkMunicipio, String nome) {
        this.pkMunicipio = pkMunicipio;
        this.nome = nome;
    }

    public Integer getPkMunicipio() {
        return pkMunicipio;
    }

    public void setPkMunicipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }

    public Provincia getFkProvincia() {
        return fkProvincia;
    }

    public void setFkProvincia(Provincia fkProvincia) {
        this.fkProvincia = fkProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMunicipio != null ? pkMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.pkMunicipio == null && other.pkMunicipio != null) || (this.pkMunicipio != null && !this.pkMunicipio.equals(other.pkMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Municipio[ pkMunicipio=" + pkMunicipio + " ]";
    }
    
}
