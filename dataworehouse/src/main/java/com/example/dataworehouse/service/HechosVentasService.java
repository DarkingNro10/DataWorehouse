package com.example.dataworehouse.service;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.sql.Date;


@Service
public class HechosVentasService {

    @PersistenceContext
    private EntityManager entityManager;

    // Consulta 1: Total de Ventas por Categoría
    public List<Map<String, Object>> obtenerVentasPorCategoria() {
        TypedQuery<Map<String, Object>> query = entityManager.createQuery(
                "SELECT new map(c.nombre AS categoria, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimProducto p ON h.productoKey = p.productoKey " +
                        "JOIN DimCategoria c ON p.categoriaID = c.categoriaKey " + // Usamos 'categoriaID' de DimProducto
                        "GROUP BY c.nombre",
                (Class<Map<String, Object>>)(Class<?>)Map.class // Conversión explícita
        );
        return query.getResultList();
    }

    // Ventas por Categoría con filtro por mes y año
    public List<Map<String, Object>> obtenerVentasPorCategoriaConFiltros(String mes, String año) {
        StringBuilder queryStr = new StringBuilder(
                "SELECT new map(c.nombre AS categoria, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimProducto p ON h.productoKey = p.productoKey " +
                        "JOIN DimCategoria c ON p.categoriaID = c.categoriaKey " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey "
        );

        // Agregar filtros de mes y año si existen
        if (mes != null && !mes.isEmpty()) {
            queryStr.append("WHERE t.mes = :mes ");
        }
        if (año != null && !año.isEmpty()) {
            if (mes != null && !mes.isEmpty()) {
                queryStr.append("AND t.año = :año ");
            } else {
                queryStr.append("WHERE t.año = :año ");
            }
        }

        queryStr.append("GROUP BY c.nombre");

        TypedQuery<Map<String, Object>> query = entityManager.createQuery(queryStr.toString(), (Class<Map<String, Object>>)(Class<?>)Map.class);

        // Establecer los parámetros si existen
        if (mes != null && !mes.isEmpty()) {
            query.setParameter("mes", Integer.parseInt(mes));
        }
        if (año != null && !año.isEmpty()) {
            query.setParameter("año", Integer.parseInt(año));
        }

        return query.getResultList();
    }



    // Consulta 2: Ventas Mensuales
    public List<Map<String, Object>> obtenerVentasPorMes() {
        TypedQuery<Map<String, Object>> query = entityManager.createQuery(
                "SELECT new map(t.mes AS mes, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey " +
                        "GROUP BY t.mes ORDER BY t.mes",
                (Class<Map<String, Object>>)(Class<?>)Map.class // Conversión explícita
        );
        return query.getResultList();
    }

    // Nueva consulta: Ventas Mensuales con filtro por mes y año
    public List<Map<String, Object>> obtenerVentasPorMesConFiltros(String mes, String año) {
        StringBuilder queryStr = new StringBuilder(
                "SELECT new map(t.mes AS mes, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey "
        );

        if (mes != null && !mes.isEmpty()) {
            queryStr.append("WHERE t.mes = :mes ");
        }
        if (año != null && !año.isEmpty()) {
            if (mes != null && !mes.isEmpty()) {
                queryStr.append("AND t.año = :año ");
            } else {
                queryStr.append("WHERE t.año = :año ");
            }
        }

        queryStr.append("GROUP BY t.mes ORDER BY t.mes");

        TypedQuery<Map<String, Object>> query = entityManager.createQuery(queryStr.toString(), (Class<Map<String, Object>>)(Class<?>)Map.class);

        if (mes != null && !mes.isEmpty()) {
            query.setParameter("mes", Integer.parseInt(mes));
        }
        if (año != null && !año.isEmpty()) {
            query.setParameter("año", Integer.parseInt(año));
        }

        return query.getResultList();
    }

    // Consulta 3: Ventas por Año
    public List<Map<String, Object>> obtenerVentasPorAnio() {
        TypedQuery<Map<String, Object>> query = entityManager.createQuery(
                "SELECT new map(t.año AS anio, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey " +
                        "GROUP BY t.año ORDER BY t.año",
                (Class<Map<String, Object>>)(Class<?>)Map.class // Conversión explícita
        );
        return query.getResultList();
    }

    // Nueva consulta: Ventas por Año con filtro por mes y año
    public List<Map<String, Object>> obtenerVentasPorAnioConFiltros(String mes, String año) {
        StringBuilder queryStr = new StringBuilder(
                "SELECT new map(t.año AS anio, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey "
        );

        if (mes != null && !mes.isEmpty()) {
            queryStr.append("WHERE t.mes = :mes ");
        }
        if (año != null && !año.isEmpty()) {
            if (mes != null && !mes.isEmpty()) {
                queryStr.append("AND t.año = :año ");
            } else {
                queryStr.append("WHERE t.año = :año ");
            }
        }

        queryStr.append("GROUP BY t.año ORDER BY t.año");

        TypedQuery<Map<String, Object>> query = entityManager.createQuery(queryStr.toString(), (Class<Map<String, Object>>)(Class<?>)Map.class);

        if (mes != null && !mes.isEmpty()) {
            query.setParameter("mes", Integer.parseInt(mes));
        }
        if (año != null && !año.isEmpty()) {
            query.setParameter("año", Integer.parseInt(año));
        }

        return query.getResultList();
    }

    // Consulta 4: Top 5 Clientes con Más Ventas
    public List<Map<String, Object>> obtenerTopClientes() {
        TypedQuery<Map<String, Object>> query = entityManager.createQuery(
                "SELECT new map(c.nombre AS cliente, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimCliente c ON h.clienteKey = c.clienteKey " +
                        "GROUP BY c.nombre ORDER BY SUM(h.total) DESC",
                (Class<Map<String, Object>>)(Class<?>)Map.class // Conversión explícita
        ).setMaxResults(5);
        return query.getResultList();
    }

    // Nueva consulta: Top 5 Clientes con Más Ventas con filtro por mes y año
    public List<Map<String, Object>> obtenerTopClientesConFiltros(String mes, String año) {
        StringBuilder queryStr = new StringBuilder(
                "SELECT new map(c.nombre AS cliente, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimCliente c ON h.clienteKey = c.clienteKey " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey "
        );

        if (mes != null && !mes.isEmpty()) {
            queryStr.append("WHERE t.mes = :mes ");
        }
        if (año != null && !año.isEmpty()) {
            if (mes != null && !mes.isEmpty()) {
                queryStr.append("AND t.año = :año ");
            } else {
                queryStr.append("WHERE t.año = :año ");
            }
        }

        queryStr.append("GROUP BY c.nombre ORDER BY SUM(h.total) DESC");

        TypedQuery<Map<String, Object>> query = entityManager.createQuery(queryStr.toString(), (Class<Map<String, Object>>)(Class<?>)Map.class)
                .setMaxResults(5);

        if (mes != null && !mes.isEmpty()) {
            query.setParameter("mes", Integer.parseInt(mes));
        }
        if (año != null && !año.isEmpty()) {
            query.setParameter("año", Integer.parseInt(año));
        }

        return query.getResultList();
    }

    // Consulta 5: Ventas por Método de Pago
    public List<Map<String, Object>> obtenerVentasPorMetodoPago() {
        TypedQuery<Map<String, Object>> query = entityManager.createQuery(
                "SELECT new map(m.descripcion AS metodoPago, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimMetodoPago m ON h.metodoKey = m.metodoKey " +
                        "GROUP BY m.descripcion",
                (Class<Map<String, Object>>)(Class<?>)Map.class // Conversión explícita
        );
        return query.getResultList();
    }

    // Nueva consulta: Ventas por Método de Pago con filtro por mes y año
    public List<Map<String, Object>> obtenerVentasPorMetodoPagoConFiltros(String mes, String año) {
        StringBuilder queryStr = new StringBuilder(
                "SELECT new map(m.descripcion AS metodoPago, SUM(h.total) AS totalVentas) " +
                        "FROM HechosVentas h " +
                        "JOIN DimMetodoPago m ON h.metodoKey = m.metodoKey " +
                        "JOIN DimTiempo t ON h.tiempoKey = t.tiempoKey "
        );

        if (mes != null && !mes.isEmpty()) {
            queryStr.append("WHERE t.mes = :mes ");
        }
        if (año != null && !año.isEmpty()) {
            if (mes != null && !mes.isEmpty()) {
                queryStr.append("AND t.año = :año ");
            } else {
                queryStr.append("WHERE t.año = :año ");
            }
        }

        queryStr.append("GROUP BY m.descripcion");

        TypedQuery<Map<String, Object>> query = entityManager.createQuery(queryStr.toString(), (Class<Map<String, Object>>)(Class<?>)Map.class);

        if (mes != null && !mes.isEmpty()) {
            query.setParameter("mes", Integer.parseInt(mes));
        }
        if (año != null && !año.isEmpty()) {
            query.setParameter("año", Integer.parseInt(año));
        }

        return query.getResultList();
    }

}
