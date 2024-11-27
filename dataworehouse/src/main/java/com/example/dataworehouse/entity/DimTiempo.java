package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "dimtiempo")
@Data
public class DimTiempo {
    @Id
    @Column(name = "TiempoKey")
    private Date tiempoKey; // Fecha en formato String o Date

    private Integer año;
    private Integer mes;
    private Integer dia;

    @Column(name = "DiaSemana")
    private String diaSemana;
}