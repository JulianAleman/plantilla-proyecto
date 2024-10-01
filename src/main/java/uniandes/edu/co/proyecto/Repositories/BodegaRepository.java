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
        double getPROMEDIO_OCUPACION();
    }

    @Query(value = "SELECT * FROM Bodega", nativeQuery = true)
    Collection<Bodega> getBodegas();

    @Query(value = "SELECT * FROM Bodega WHERE Id = :id", nativeQuery = true)
    Bodega getBodega(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bodega (Id, Nombre, Tamanio, Id_Sucursal) VALUES (proyecto-1-superandes_sequence.nextval, :nombre, :tamanio, :id_sucursal)", nativeQuery = true)
    void insertBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("id_sucursal") Sucursal id_Sucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bodega SET Nombre = :nombre, Tamanio = :tamanio, Id_Sucursal = :id_sucursal WHERE id = :id", nativeQuery = true)
    void updateBodega(@Param("id") long id, @Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("id_sucursal") Sucursal id_Sucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bodega WHERE Id = :id", nativeQuery = true)
    void deleteBodega(@Param("id") long id);


    
    @Query(value ="SELECT b.nombre AS bodega, \r\n"+ 
        "(SUM(ieb.totalExistencia * ee.volumen_m3) / b.tamaño) * 100 AS porcentajeOcupacion \r\n" +
       "FROM Bodega b \r\n" +
       "INNER JOIN InfoExtraBodega ieb ON b.Id = ieb.Id_Bodega\r\n" +
       "INNER JOIN Producto p ON ieb.codigobarras_producto = p.codigobarras \r\n" +
       "INNER JOIN EspecificacionEmpacado ee ON p.Id_EspecificacionEmpacado = ee.Id \r\n" +
       "WHERE p.codigoBarras IN :codigos AND b.sucursal.id = :sucursal \r\n" +
       "GROUP BY b.nombre", nativeQuery = true)
    Collection<Bodega> mostrarocupaciondeunabodega(@Param("sucursal") Long sucursal, @Param ("codigos") List<Long> codigos);
    
    @Query(value ="SELECT b.nombre AS bodega, \r\n"+ 
       "FROM Bodega b \r\n"+
       "INNER JOIN InfoExtraBodega ieb ON b.Id = ieb.Id_Bodega\r\n" +
       "INNER JOIN Producto p ON ieb.codigobarras_producto = p.codigobarras \r\n" +
       "INNER JOIN EspecificacionEmpacado ee ON p.Id_EspecificacionEmpacado = ee.Id \r\n" +
       "GROUP BY b.nombre", nativeQuery = true)
    Collection<respuestaocupaciondeunabodega> mostrarbodegas1();
}
