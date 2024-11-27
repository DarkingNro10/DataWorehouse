package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimCliente;
import com.example.dataworehouse.repository.DimClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimClienteService {
    @Autowired
    private DimClienteRepository dimClienteRepository;

    public List<DimCliente> obtenerTodosLosClientes() {
        return dimClienteRepository.findAll();
    }

    public DimCliente obtenerClientePorId(Integer id) {
        return dimClienteRepository.findById(id).orElse(null);
    }

    public DimCliente guardarCliente(DimCliente cliente) {
        return dimClienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        dimClienteRepository.deleteById(id);
    }
}