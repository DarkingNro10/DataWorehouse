package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimProveedor;
import com.example.dataworehouse.repository.DimProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimProveedorService {
    @Autowired
    private DimProveedorRepository dimProveedorRepository;

    public List<DimProveedor> obtenerTodosLosProveedores() {
        return dimProveedorRepository.findAll();
    }

    public DimProveedor obtenerProveedorPorId(Integer id) {
        return dimProveedorRepository.findById(id).orElse(null);
    }

    public DimProveedor guardarProveedor(DimProveedor proveedor) {
        return dimProveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        dimProveedorRepository.deleteById(id);
    }
}