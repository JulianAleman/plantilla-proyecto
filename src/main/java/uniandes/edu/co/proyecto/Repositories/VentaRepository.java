package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query(value = "SELECT * FROM Venta", nativeQuery = true)
    Collection<Venta> getAllVentas();

    @Query(value = "SELECT * FROM Venta WHERE Id = :id", nativeQuery = true)
    Categoria getVenta(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Venta (Id, Fecha, Id_Sucursal, Id_Cliente) VALUES (proyecto-1-superandes_sequence.nextval, :fecha, :idSucursal, :idCliente)", nativeQuery = true)
    void insertVenta(@Param("fecha") Date fecha, @Param("idSucursal") Long idSucursal, @Param("idCliente") Long idCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Venta SET Fecha = :fecha, Id_Sucursal = :idSucursal, Id_Cliente = :idCliente WHERE Id = :id", nativeQuery = true)
    void updateVenta(@Param("id") Long id, @Param("fecha") Date fecha, 
                    @Param("idSucursal") Long idSucursal, @Param("idCliente") Long idCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Venta WHERE Id = :id", nativeQuery = true)
    void deleteVenta(@Param("id") Long id);
}
