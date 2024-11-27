package com.example.dataworehouse.service;

import com.example.dataworehouse.entity.DimEmpleado;
import com.example.dataworehouse.repository.DimEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimEmpleadoService {
    @Autowired
    private DimEmpleadoRepository dimEmpleadoRepository;

    public List<DimEmpleado> obtenerTodosLosEmpleados() {
        return dimEmpleadoRepository.findAll();
    }

    public DimEmpleado obtenerEmpleadoPorId(Integer id) {
        return dimEmpleadoRepository.findById(id).orElse(null);
    }

    public DimEmpleado guardarEmpleado(DimEmpleado empleado) {
        return dimEmpleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Integer id) {
        dimEmpleadoRepository.deleteById(id);
    }
}