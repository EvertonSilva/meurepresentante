package br.com.luque.meurepresentante.dominio;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta classe implementa cidadaos.
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "cidadao")
public class Cidadao extends EntidadeDominio {

    @Column(name = "cpf")
    private String CPF;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha_cripto")
    private String senha;
    @Column(name = "telefone")
    private Telefone telefone;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "politicos_acompanhados", joinColumns = {
        @JoinColumn(name = "cidadao_id")}, inverseJoinColumns = {
        @JoinColumn(name = "politico_id")})
    private List<Politico> acompanhar;
    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipoNotificacao;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void addPolitico(Politico politico) {
        if (!this.acompanhar.contains(politico)) {
            this.acompanhar.add(politico);
        }
    }

    public boolean removePolitico(Politico politico) {
        return this.acompanhar.remove(politico);
    }

    public Politico removePoliticoAt(int i) {
        return this.acompanhar.remove(i);
    }

    public int countPoliticos() {
        return this.acompanhar.size();
    }

    public Politico getPoliticoAt(int i) {
        return this.acompanhar.get(i);
    }

    public List<Politico> getAcompanhar() {
        return acompanhar;
    }

    public void setAcompanhar(List<Politico> acompanhar) {
        this.acompanhar = acompanhar;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
