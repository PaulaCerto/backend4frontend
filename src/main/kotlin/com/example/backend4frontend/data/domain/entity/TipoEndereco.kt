package com.example.backend4frontend.data.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="TIPO_ENDERECO")
@Data
@Builder
public class TipoEndereco implements Serializable {

    @Id
    @Column(name="ID_ENDERECO", nullable = false)
    val idEndereco: Long = 0

    @Id
    @Column(name="ID_TIPO", nullable = false)
    val idTipo: Long = 0

}
