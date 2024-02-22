package com.example.backend4frontend.data.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="CIDADE")
@Data
@Builder
class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CIDADE", nullable = false)
    val idCidade: Long = 0

    @Column(name="NM_CIDADE", nullable = false)
    val nmCidade: String = ""

    @Column(name="SG_CIDADE", nullable = false)
    val sgCidade: String = ""

    public Cidade(Long idCidade, String nmCidade, String sgCidade) {
        this.idCidade = idCidade;
        this.nmCidade = nmCidade;
        this.sgCidade = sgCidade;
    }

    public Cidade(){}
}
