package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimproductos")
@Data
public class DimProducto {
    @Id
    @Column(name = "ProductoKey")
    private Integer productoKey;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "CategoriaID") // Asegúrate de que coincide con el nombre exacto de la columna
    private Integer categoriaID;
}