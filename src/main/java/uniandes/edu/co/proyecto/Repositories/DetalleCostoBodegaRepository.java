package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.DetalleCostoBodega;

public interface DetalleCostoBodegaRepository extends JpaRepository<DetalleCostoBodega, Long> {
    
    @Query(value = "SELECT * FROM Detalle_Costo_Bodega", nativeQuery = true)
    Collection<DetalleCostoBodega> getAllDetalleCostoBodega();
     
    @Query(value = "SELECT * FROM Detalle_Costo_Bodega WHERE Id = :id", nativeQuery = true)
    DetalleCostoBodega getDetalleCostoBodega(@Param("id") Long id);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (proyecto-1-superandes_sequence.nextval, :costo, :cantidad)", nativeQuery = true)
    void insertDetalleCostoBodega(@Param("costo") Double costo, @Param("cantidad") Integer cantidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Detalle_Costo_Bodega SET Costo_UnitarioBodega = :costos, Cantidad_Existencia = :cantidad WHERE Id = :id", nativeQuery = true)
    void updateDetalleCostoBodega(@Param("id") Long id, @Param("costo") Double costo, @Param("cantidad") Integer cantidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Detalle_Costo_Bodega WHERE Id = :id", nativeQuery = true)
    void deleteDetalleCostoBodega(@Param("id") Long id);
    
}
