package com.example.backend4frontend.data.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="ENDERECO_PESSOA")
@Data
@Builder
public class EnderecoPessoa implements Serializable {

    @Id
    @Column(name="ID_PESSOA", nullable = false)
    val idPessoa: Long = 0

    @Id
    @Column(name="ID_ENDERECO", nullable = false)
    val idEndereco: Long = 0

}
