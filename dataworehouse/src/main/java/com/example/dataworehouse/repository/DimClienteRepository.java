package com.example.dataworehouse.repository;
import com.example.dataworehouse.entity.DimCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimClienteRepository extends JpaRepository<DimCliente, Integer> {
}