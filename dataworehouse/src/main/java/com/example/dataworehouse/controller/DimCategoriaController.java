package com.example.dataworehouse.controller;
import com.example.dataworehouse.entity.DimCategoria;
import com.example.dataworehouse.service.DimCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class DimCategoriaController {

    @Autowired
    private DimCategoriaService dimCategoriaService;

    @GetMapping
    public List<DimCategoria> obtenerTodasLasCategorias() {
        return dimCategoriaService.obtenerTodasLasCategorias();
    }

    @GetMapping("/{id}")
    public DimCategoria obtenerCategoriaPorId(@PathVariable Integer id) {
        return dimCategoriaService.obtenerCategoriaPorId(id);
    }

    @PostMapping
    public DimCategoria guardarCategoria(@RequestBody DimCategoria categoria) {
        return dimCategoriaService.guardarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Integer id) {
        dimCategoriaService.eliminarCategoria(id);
    }
}