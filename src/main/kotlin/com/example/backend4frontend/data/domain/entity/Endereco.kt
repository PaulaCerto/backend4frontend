package com.example.backend4frontend.data.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="ENDERECO")
@Data
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ENDERECO", nullable = false)
    val id: Long = 0

    @Column(name="LOGRADOURO", nullable = false)
    val logradouro: String = ""

    @Column(name = "NUMERO", nullable = false)
    val numero: String = ""

    @Column(name = "COMPLEMENTO", nullable = false)
    val complemento: String = ""

    @Column(name = "BAIRRO", nullable = false)
    val bairro: String = ""

    @Column(name = "CIDADE", nullable = false)
    val cidade: String = ""

    @Column(name = "ESTADO", nullable = false)
    val estado: String = ""

    @ManyToOne
    @JoinTable(
            name = "TIPO_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_ENDERECO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIPO"))
    val tipo: Tipo = new Tipo()

    @JsonIgnore
    @ManyToMany(mappedBy = "listEndereco", cascade = CascadeType.ALL)
    val idPessoa: List<Pessoa> = new ArrayList<>()

    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, Tipo tipo, List<Pessoa> idPessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
        this.idPessoa = idPessoa;
    }

    public Endereco() {}
}
