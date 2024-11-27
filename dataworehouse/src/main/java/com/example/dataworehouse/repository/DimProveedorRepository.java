package com.example.dataworehouse.repository;

import com.example.dataworehouse.entity.DimProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimProveedorRepository extends JpaRepository<DimProveedor, Integer> {
}