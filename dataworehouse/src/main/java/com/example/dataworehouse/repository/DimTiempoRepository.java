package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimTiempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimTiempoRepository extends JpaRepository<DimTiempo, String> {
}