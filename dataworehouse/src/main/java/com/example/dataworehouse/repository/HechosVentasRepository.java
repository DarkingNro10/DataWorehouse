package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.HechosVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HechosVentasRepository extends JpaRepository<HechosVentas, Integer> {
}