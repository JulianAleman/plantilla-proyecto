package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraBodega;
import uniandes.edu.co.proyecto.modelo.InfoExtraBodegaPK;

public interface InfoExtraBodegaRepository extends JpaRepository<InfoExtraBodega, InfoExtraBodegaPK> {

    @Query(value = "SELECT * FROM InfoExtraBodega", nativeQuery = true)
    Collection<InfoExtraBodega> getAllInfoExtraBodega();

    @Query(value = "SELECT * FROM InfoExtraBodega WHERE CodigoBarras_Producto = :codBar AND Id_Bodega = :idBod", nativeQuery = true)
    InfoExtraBodega getInfoExtraBodega(@Param("codBar") Long codBar, @Param("idBod") Long idBod);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO InfoExtraBodega (CodigoBarras_Producto, Id_bodega, TotalExistencia, CostoPromedio, CapacidadAlmacenamiento, NivelMinimoReorden, Id_detalleCostoBodega) VALUES (proyecto-1-superandes_sequence.nextval, :codBar, :idBod, :existencia, :costo, :capacidad, :reorden, :idCostoBodega)", 
            nativeQuery = true)
    void insertInfoExtraBodega(@Param("codBar") Long codBar, @Param("idBod") Long idBod, @Param("existencia") Integer existencia,
                @Param("costo") Double costo, @Param("capacidad") Double capacidad, @Param("reorden") Double reorden,
                 @Param("idCostoBodega") Double idCostoBodega);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE InfoExtraBodega SET CodigoBarras_Producto = :codBarAct, Id_bodega = :idBodAct, TotalExistencia = :existencia, CostoPromedio = :costo, CapacidadAlmacenamiento = :capacidad, NivelMinimoReorden = :reorden, Id_detalleCostoBodega = :idCostoBodega WHERE CodigoBarras_Producto = :codBar AND Id_bodega = :idBod", nativeQuery = true)
    void updateInfoExtraBodega(@Param("codBarAct") Long codBarAct, @Param("idBodAct") Long idBodAct, @Param("codBar") Long codBar, @Param("idBod") Long idBod, 
    @Param("existencia") Integer existencia, @Param("costo") Double costo, @Param("capacidad") Double capacidad, 
    @Param("reorden") Double reorden, @Param("idCostoBodega") Long idCostoBodega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM InfoExtraBodega WHERE CodigoBarras_Producto = :codBar AND Id_bodega = :idBod", nativeQuery = true)
    void deleteInfoExtraBodega(@Param("codBar") Long codBar, @Param("idBod") Long idBod);
}
