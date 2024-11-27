package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimProductoRepository extends JpaRepository<DimProducto, Integer> {
}
