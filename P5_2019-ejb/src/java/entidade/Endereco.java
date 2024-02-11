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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByPkEndereco", query = "SELECT e FROM Endereco e WHERE e.pkEndereco = :pkEndereco"),
    @NamedQuery(name = "Endereco.findByRua", query = "SELECT e FROM Endereco e WHERE e.rua = :rua"),
    @NamedQuery(name = "Endereco.findByNumeroCasa", query = "SELECT e FROM Endereco e WHERE e.numeroCasa = :numeroCasa")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_endereco")
    private Integer pkEndereco;
    @Size(max = 50)
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero_casa")
    private Integer numeroCasa;
    @OneToMany(mappedBy = "fkEndereco")
    private List<Pessoa> pessoaList;
    @JoinColumn(name = "fk_comuna", referencedColumnName = "pk_comuna")
    @ManyToOne(optional = false)
    private Comuna fkComuna;

    public Endereco() {
    }

    public Endereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public Integer getPkEndereco() {
        return pkEndereco;
    }

    public void setPkEndereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public Comuna getFkComuna() {
        return fkComuna;
    }

    public void setFkComuna(Comuna fkComuna) {
        this.fkComuna = fkComuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEndereco != null ? pkEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.pkEndereco == null && other.pkEndereco != null) || (this.pkEndereco != null && !this.pkEndereco.equals(other.pkEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Endereco[ pkEndereco=" + pkEndereco + " ]";
    }
    
}
