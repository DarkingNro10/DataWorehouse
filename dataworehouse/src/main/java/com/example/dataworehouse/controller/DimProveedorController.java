package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimProveedor;
import com.example.dataworehouse.service.DimProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class DimProveedorController {

    @Autowired
    private DimProveedorService dimProveedorService;

    @GetMapping
    public List<DimProveedor> obtenerTodosLosProveedores() {
        return dimProveedorService.obtenerTodosLosProveedores();
    }

    @GetMapping("/{id}")
    public DimProveedor obtenerProveedorPorId(@PathVariable Integer id) {
        return dimProveedorService.obtenerProveedorPorId(id);
    }

    @PostMapping
    public DimProveedor guardarProveedor(@RequestBody DimProveedor proveedor) {
        return dimProveedorService.guardarProveedor(proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id) {
        dimProveedorService.eliminarProveedor(id);
    }
}