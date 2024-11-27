package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimmetodospago")
@Data
public class DimMetodoPago {
    @Id
    @Column(name = "MetodoKey")
    private Integer metodoKey;

    private String descripcion;
}