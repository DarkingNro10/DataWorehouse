package com.example.dataworehouse.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimcategorias") // Nombre exacto de la tabla
@Data
public class DimCategoria {

    @Id
    @Column(name = "CategoriaKey") // Nombre exacto de la columna
    private Integer categoriaKey;

    @Column(name = "Nombre") // Nombre exacto de la columna
    private String nombre;
}