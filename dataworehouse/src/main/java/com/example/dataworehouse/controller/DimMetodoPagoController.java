package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimMetodoPago;
import com.example.dataworehouse.service.DimMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos-pago")
public class DimMetodoPagoController {

    @Autowired
    private DimMetodoPagoService dimMetodoPagoService;

    @GetMapping
    public List<DimMetodoPago> obtenerTodosLosMetodosDePago() {
        return dimMetodoPagoService.obtenerTodosLosMetodosDePago();
    }

    @GetMapping("/{id}")
    public DimMetodoPago obtenerMetodoPagoPorId(@PathVariable Integer id) {
        return dimMetodoPagoService.obtenerMetodoPagoPorId(id);
    }

    @PostMapping
    public DimMetodoPago guardarMetodoPago(@RequestBody DimMetodoPago metodoPago) {
        return dimMetodoPagoService.guardarMetodoPago(metodoPago);
    }

    @DeleteMapping("/{id}")
    public void eliminarMetodoPago(@PathVariable Integer id) {
        dimMetodoPagoService.eliminarMetodoPago(id);
    }
}