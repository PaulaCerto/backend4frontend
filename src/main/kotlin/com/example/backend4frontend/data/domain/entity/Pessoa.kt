package com.example.backend4frontend.data.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity(name = "pessoa")
@Table(name="PESSOA")
@Data
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PESSOA", nullable = false)
    val id: Long = 0

    @Column(name="NAME", length = 50, nullable = false)
    val nome: String = ""

    @Column(name = "IDADE", length = 3, nullable = false)
    val nrIdade: Integer = 0

    @Column(name = "CPF", length = 11, nullable = false)
    val nrCpf: String = ""

    @Column(name = "TELEFONE", length = 11, nullable = false)
    val nrTelefone: String = ""

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ENDERECO_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    val listEndereco: List<Endereco> = new ArrayList<>()

    public Pessoa(Long id, String nome, Integer nrIdade, String nrCpf, String nrTelefone, List<Endereco> listEndereco) {
        this.id = id;
        this.nome = nome;
        this.nrIdade = nrIdade;
        this.nrCpf = nrCpf;
        this.nrTelefone = nrTelefone;
        this.listEndereco = listEndereco;
    }

    public Pessoa() {}
}
