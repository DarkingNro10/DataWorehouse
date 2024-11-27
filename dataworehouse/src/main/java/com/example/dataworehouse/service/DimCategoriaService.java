package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimCategoria;
import com.example.dataworehouse.repository.DimCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimCategoriaService {
    @Autowired
    private DimCategoriaRepository dimCategoriaRepository;

    public List<DimCategoria> obtenerTodasLasCategorias() {
        return dimCategoriaRepository.findAll();
    }

    public DimCategoria obtenerCategoriaPorId(Integer id) {
        return dimCategoriaRepository.findById(id).orElse(null);
    }

    public DimCategoria guardarCategoria(DimCategoria categoria) {
        return dimCategoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Integer id) {
        dimCategoriaRepository.deleteById(id);
    }
}