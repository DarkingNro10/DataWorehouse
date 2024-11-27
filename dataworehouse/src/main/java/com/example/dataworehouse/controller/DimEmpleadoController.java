package com.example.dataworehouse.controller;

import com.example.dataworehouse.entity.DimEmpleado;
import com.example.dataworehouse.service.DimEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class DimEmpleadoController {

    @Autowired
    private DimEmpleadoService dimEmpleadoService;

    @GetMapping
    public List<DimEmpleado> obtenerTodosLosEmpleados() {
        return dimEmpleadoService.obtenerTodosLosEmpleados();
    }

    @GetMapping("/{id}")
    public DimEmpleado obtenerEmpleadoPorId(@PathVariable Integer id) {
        return dimEmpleadoService.obtenerEmpleadoPorId(id);
    }

    @PostMapping
    public DimEmpleado guardarEmpleado(@RequestBody DimEmpleado empleado) {
        return dimEmpleadoService.guardarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Integer id) {
        dimEmpleadoService.eliminarEmpleado(id);
    }
}