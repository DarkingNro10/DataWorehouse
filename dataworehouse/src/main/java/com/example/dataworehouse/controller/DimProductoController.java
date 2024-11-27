package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimProducto;
import com.example.dataworehouse.service.DimProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class DimProductoController {

    @Autowired
    private DimProductoService dimProductoService;

    @GetMapping
    public List<DimProducto> obtenerTodosLosProductos() {
        return dimProductoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public DimProducto obtenerProductoPorId(@PathVariable Integer id) {
        return dimProductoService.obtenerProductoPorId(id);
    }

    @PostMapping
    public DimProducto guardarProducto(@RequestBody DimProducto producto) {
        return dimProductoService.guardarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        dimProductoService.eliminarProducto(id);
    }
}