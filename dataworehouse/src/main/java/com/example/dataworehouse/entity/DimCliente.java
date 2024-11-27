package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimclientes")
@Data
public class DimCliente {
    @Id
    @Column(name = "ClienteKey")
    private Integer clienteKey;

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
}
