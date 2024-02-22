package com.example.backend4frontend.data.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="ESTADO")
@Data
@Builder
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ESTADO", nullable = false)
    val idEstado: Long = 0

    @Column(name="NM_ESTADO", nullable = false)
    val nmEstado: String = 0

    @Column(name="SG_ESTADO", nullable = false)
    val sgEstado: String = 0

    public Estado(Long idEstado, String nmEstado, String sgEstado) {
        this.idEstado = idEstado;
        this.nmEstado = nmEstado;
        this.sgEstado = sgEstado;
    }

    public Estado() {}
}
