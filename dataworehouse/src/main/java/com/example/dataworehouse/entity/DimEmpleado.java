package com.example.dataworehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimempleados")
@Data
public class DimEmpleado {
    @Id
    @Column(name = "EmpleadoKey")
    private Integer empleadoKey;

    private String nombre;
    private String puesto;
}