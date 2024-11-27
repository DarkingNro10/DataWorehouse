package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimProducto;
import com.example.dataworehouse.repository.DimProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimProductoService {
    @Autowired
    private DimProductoRepository dimProductoRepository;

    public List<DimProducto> obtenerTodosLosProductos() {
        return dimProductoRepository.findAll();
    }

    public DimProducto obtenerProductoPorId(Integer id) {
        return dimProductoRepository.findById(id).orElse(null);
    }

    public DimProducto guardarProducto(DimProducto producto) {
        return dimProductoRepository.save(producto);
    }

    public void eliminarProducto(Integer id) {
        dimProductoRepository.deleteById(id);
    }
}