package com.example.dataworehouse.controller;

import com.example.dataworehouse.service.HechosVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class HechosVentasController {

    @Autowired
    private HechosVentasService hechosVentasService;

    // Endpoint 1: Total de Ventas por Categoría
    @GetMapping("/por-categoria")
    public List<Map<String, Object>> obtenerVentasPorCategoria() {
        return hechosVentasService.obtenerVentasPorCategoria();
    }

    // Nuevo endpoint: Ventas por Categoría con filtro por mes y año
    @GetMapping("/por-categoria/filtrado")
    public List<Map<String, Object>> obtenerVentasPorCategoriaConFiltros(@RequestParam(required = false) String mes,
                                                                         @RequestParam(required = false) String año) {
        return hechosVentasService.obtenerVentasPorCategoriaConFiltros(mes, año);
    }

    // Endpoint 2: Ventas Mensuales
    @GetMapping("/por-mes")
    public List<Map<String, Object>> obtenerVentasPorMes() {
        return hechosVentasService.obtenerVentasPorMes();
    }

    // Nuevo endpoint: Ventas Mensuales con filtro por mes y año
    @GetMapping("/por-mes/filtrado")
    public List<Map<String, Object>> obtenerVentasPorMesConFiltros(@RequestParam(required = false) String mes,
                                                                   @RequestParam(required = false) String año) {
        return hechosVentasService.obtenerVentasPorMesConFiltros(mes, año);
    }

    // Endpoint 3: Ventas por Año
    @GetMapping("/por-anio")
    public List<Map<String, Object>> obtenerVentasPorAnio() {
        return hechosVentasService.obtenerVentasPorAnio();
    }

    // Nuevo endpoint: Ventas por Año con filtro por mes y año
    @GetMapping("/por-anio/filtrado")
    public List<Map<String, Object>> obtenerVentasPorAnioConFiltros(@RequestParam(required = false) String mes,
                                                                    @RequestParam(required = false) String año) {
        return hechosVentasService.obtenerVentasPorAnioConFiltros(mes, año);
    }

    // Endpoint 4: Top 5 Clientes con Más Ventas
    @GetMapping("/top-clientes")
    public List<Map<String, Object>> obtenerTopClientes() {
        return hechosVentasService.obtenerTopClientes();
    }

    // Nuevo endpoint: Top 5 Clientes con Más Ventas con filtro por mes y año
    @GetMapping("/top-clientes/filtrado")
    public List<Map<String, Object>> obtenerTopClientesConFiltros(@RequestParam(required = false) String mes,
                                                                  @RequestParam(required = false) String año) {
        return hechosVentasService.obtenerTopClientesConFiltros(mes, año);
    }

    // Endpoint 5: Ventas por Método de Pago
    @GetMapping("/por-metodo-pago")
    public List<Map<String, Object>> obtenerVentasPorMetodoPago() {
        return hechosVentasService.obtenerVentasPorMetodoPago();
    }

    // Nuevo endpoint: Ventas por Método de Pago con filtro por mes y año
    @GetMapping("/por-metodo-pago/filtrado")
    public List<Map<String, Object>> obtenerVentasPorMetodoPagoConFiltros(@RequestParam(required = false) String mes,
                                                                          @RequestParam(required = false) String año) {
        return hechosVentasService.obtenerVentasPorMetodoPagoConFiltros(mes, año);
    }
}
