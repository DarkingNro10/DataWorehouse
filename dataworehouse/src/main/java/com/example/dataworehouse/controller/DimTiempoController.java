package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimTiempo;
import com.example.dataworehouse.service.DimTiempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiempo")
public class DimTiempoController {

    @Autowired
    private DimTiempoService dimTiempoService;

    @GetMapping
    public List<DimTiempo> obtenerTodosLosTiempos() {
        return dimTiempoService.obtenerTodosLosTiempos();
    }

    @GetMapping("/{id}")
    public DimTiempo obtenerTiempoPorId(@PathVariable String id) {
        return dimTiempoService.obtenerTiempoPorId(id);
    }

    @PostMapping
    public DimTiempo guardarTiempo(@RequestBody DimTiempo tiempo) {
        return dimTiempoService.guardarTiempo(tiempo);
    }

    @DeleteMapping("/{id}")
    public void eliminarTiempo(@PathVariable String id) {
        dimTiempoService.eliminarTiempo(id);
    }
}