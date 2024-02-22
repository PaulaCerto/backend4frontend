package com.example.backend4frontend.data.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="TIPO")
@Data
@Builder
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TIPO", nullable = false)
    val id: Long = 0

    @Column(name="NM_TIPO", nullable = false)
    val nmTipo: String = ""

    @JsonIgnore
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    val listEndereco: List<Endereco> = new ArrayList<>()

    public Tipo(Long id, String nmTipo, List<Endereco> listEndereco) {
        this.id = id;
        this.nmTipo = nmTipo;
        this.listEndereco = listEndereco;
    }

    public Tipo() {}
}
