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
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByPkConta", query = "SELECT c FROM Conta c WHERE c.pkConta = :pkConta"),
    @NamedQuery(name = "Conta.findByNome", query = "SELECT c FROM Conta c WHERE c.nome = :nome"),
    @NamedQuery(name = "Conta.findBySenha", query = "SELECT c FROM Conta c WHERE c.senha = :senha")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_conta")
    private Integer pkConta;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa")
    @ManyToOne
    private Pessoa fkPessoa;
    @JoinColumn(name = "fk_perfil", referencedColumnName = "pk_perfil")
    @ManyToOne
    private Perfil fkPerfil;
    @OneToMany(mappedBy = "fkConta")
    private List<Venda> vendaList;

    public Conta() {
    }

    public Conta(Integer pkConta) {
        this.pkConta = pkConta;
    }

    public Conta(Integer pkConta, String senha) {
        this.pkConta = pkConta;
        this.senha = senha;
    }

    public Integer getPkConta() {
        return pkConta;
    }

    public void setPkConta(Integer pkConta) {
        this.pkConta = pkConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    public Perfil getFkPerfil() {
        return fkPerfil;
    }

    public void setFkPerfil(Perfil fkPerfil) {
        this.fkPerfil = fkPerfil;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkConta != null ? pkConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.pkConta == null && other.pkConta != null) || (this.pkConta != null && !this.pkConta.equals(other.pkConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Conta[ pkConta=" + pkConta + " ]";
    }
    
}
