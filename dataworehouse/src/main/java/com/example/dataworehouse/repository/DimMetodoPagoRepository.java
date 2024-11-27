package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimMetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimMetodoPagoRepository extends JpaRepository<DimMetodoPago, Integer> {
}