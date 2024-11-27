package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimCliente;
import com.example.dataworehouse.service.DimClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class DimClienteController {

    @Autowired
    private DimClienteService dimClienteService;

    @GetMapping
    public List<DimCliente> obtenerTodosLosClientes() {
        return dimClienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public DimCliente obtenerClientePorId(@PathVariable Integer id) {
        return dimClienteService.obtenerClientePorId(id);
    }

    @PostMapping
    public DimCliente guardarCliente(@RequestBody DimCliente cliente) {
        return dimClienteService.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        dimClienteService.eliminarCliente(id);
    }
}