package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "hechosventas")
@Data
public class HechosVentas {
    @Id
    @Column(name = "VentaKey")
    private Integer ventaKey;

    @Column(name = "ClienteKey")
    private Integer clienteKey;

    @Column(name = "ProductoKey")
    private Integer productoKey;

    @Column(name = "CategoriaKey")
    private Integer categoriaKey;

    @Column(name = "ProveedorKey")
    private Integer proveedorKey;

    @Column(name = "TiempoKey")
    @Temporal(TemporalType.DATE)
    private Date tiempoKey;

    @Column(name = "EmpleadoKey")
    private Integer empleadoKey;

    @Column(name = "MetodoKey")
    private Integer metodoKey;

    private Integer cantidad;
    private Double total;
}