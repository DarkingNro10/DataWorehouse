package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimEmpleadoRepository extends JpaRepository<DimEmpleado, Integer> {
}