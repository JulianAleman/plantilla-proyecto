package uniandes.edu.co.proyecto.Repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface BodegaRepository extends JpaRepository<Bodega, Long>{

    public interface respuestaocupaciondeunabodega {
        int getPorcentaje_Ocupacion();
    }

    @Query(value = "SELECT * FROM Bodega", nativeQuery = true)
    Collection<Bodega> getBodegas();

    @Query(value = "SELECT * FROM Bodega WHERE Id = :id", nativeQuery = true)
    Bodega getBodega(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.nextval, :nombre, :tamanio, :id_sucursal)", nativeQuery = true)
    void insertBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("id_sucursal") Sucursal id_Sucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bodega SET Nombre = :nombre, Tamaño = :tamanio, Id_Sucursal = :id_sucursal WHERE id = :id", nativeQuery = true)
    void updateBodega(@Param("id") long id, @Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("id_sucursal") Sucursal id_Sucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bodega WHERE Id = :id", nativeQuery = true)
    void deleteBodega(@Param("id") long id);


    
    @Query(value ="SELECT b.Id AS Id_bodega, \r\n"+
       "INNER JOIN Info_Extra_Bodega ieb ON b.Id = ieb.Id_Bodega\r\n" +
       "INNER JOIN Producto p ON ieb.codigo_barras_producto = p.Codigo_Barras \r\n" +
       "INNER JOIN Especificacion_Empacado ee ON p.Id_Especificacion_Empacado = ee.Id \r\n" +
       "WHERE p.Codigo_Barras IN :codigos AND b.sucursal.id = :sucursal; \r\n", nativeQuery = true)
    Collection<Bodega>Bodegas(@Param("sucursal") Long sucursal, @Param ("codigos") List<Long> codigos);

    @Query(value = "SELECT b.Id AS bodega, " +
               "(SUM(ieb.total_Existencia * ee.volumen_cm3) / b.tamaño) * 100 AS Porcentaje_Ocupacion " +
               "FROM Bodega b " +
               "INNER JOIN Info_Extra_Bodega ieb ON b.Id = ieb.Id_Bodega " +
               "INNER JOIN Producto p ON ieb.codigo_barras_producto = p.codigo_barras " +
               "INNER JOIN Especificacion_Empacado ee ON p.Id_Especificacion_Empacado = ee.Id " +
               "GROUP BY b.Id, b.Tamaño", nativeQuery = true)
    Collection<respuestaocupaciondeunabodega> mostrarocupaciondeunabodega();

}

