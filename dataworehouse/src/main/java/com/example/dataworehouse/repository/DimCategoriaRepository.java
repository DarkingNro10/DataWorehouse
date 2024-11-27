package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimCategoriaRepository extends JpaRepository<DimCategoria, Integer> {
}