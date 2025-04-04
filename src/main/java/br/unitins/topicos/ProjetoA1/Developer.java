package br.unitins.topicos.ProjetoA1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "developers")
public class Developer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private LocalDate dataFundacao;

    public Developer() {
    }

    public Developer(DeveloperDTO developerDTO) {

        this.nome = developerDTO.nome();
        this.dataFundacao = developerDTO.dataFundacao();
    }

    public void setDados(DeveloperDTO developerDTO) {

        this.nome = developerDTO.nome();
        this.dataFundacao = developerDTO.dataFundacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
