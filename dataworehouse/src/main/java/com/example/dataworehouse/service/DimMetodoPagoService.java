package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimMetodoPago;
import com.example.dataworehouse.repository.DimMetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimMetodoPagoService {
    @Autowired
    private DimMetodoPagoRepository dimMetodoPagoRepository;

    public List<DimMetodoPago> obtenerTodosLosMetodosDePago() {
        return dimMetodoPagoRepository.findAll();
    }

    public DimMetodoPago obtenerMetodoPagoPorId(Integer id) {
        return dimMetodoPagoRepository.findById(id).orElse(null);
    }

    public DimMetodoPago guardarMetodoPago(DimMetodoPago metodoPago) {
        return dimMetodoPagoRepository.save(metodoPago);
    }

    public void eliminarMetodoPago(Integer id) {
        dimMetodoPagoRepository.deleteById(id);
    }
}