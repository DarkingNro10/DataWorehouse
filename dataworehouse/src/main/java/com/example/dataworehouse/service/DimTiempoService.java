package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimTiempo;
import com.example.dataworehouse.repository.DimTiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimTiempoService {
    @Autowired
    private DimTiempoRepository dimTiempoRepository;

    public List<DimTiempo> obtenerTodosLosTiempos() {
        return dimTiempoRepository.findAll();
    }

    public DimTiempo obtenerTiempoPorId(String id) {
        return dimTiempoRepository.findById(id).orElse(null);
    }

    public DimTiempo guardarTiempo(DimTiempo tiempo) {
        return dimTiempoRepository.save(tiempo);
    }

    public void eliminarTiempo(String id) {
        dimTiempoRepository.deleteById(id);
    }
}