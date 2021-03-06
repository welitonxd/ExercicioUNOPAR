package br.welitonads.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name="IdPessoa", nullable=false)
    private Integer IdPessoa;
    @Column (name="Name", nullable=false, length=80)
    private String nome;
    @Column (name="Email", nullable=false, length=80)
    private String email;
    @Column (name="Telefone", nullable=false, length=15)
    private String telefone;
    @Column (name="CPF", nullable=false, length=14)
    private String cpf;
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    private Endereco endereco;
    
    @ManyToOne (optional = false)
    @ForeignKey (name = "PessoaSexo")
    @JoinColumn(name="IdSexo", referencedColumnName = "IdSexo")
    private Sexo sexo;
    
    public Pessoa() {
        this.sexo = new Sexo();
    }

    public Integer getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Integer IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.IdPessoa != null ? this.IdPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.IdPessoa != other.IdPessoa && (this.IdPessoa == null || !this.IdPessoa.equals(other.IdPessoa))) {
            return false;
        }
        return true;
    }
    
}
