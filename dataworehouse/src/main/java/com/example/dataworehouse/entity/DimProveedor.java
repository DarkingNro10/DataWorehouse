package com.example.dataworehouse.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dimproveedores")
@Data
public class DimProveedor {
    @Id
    @Column(name = "ProveedorKey")
    private Integer proveedorKey;

    private String nombre;
    private String contacto;
    private String telefono;
}