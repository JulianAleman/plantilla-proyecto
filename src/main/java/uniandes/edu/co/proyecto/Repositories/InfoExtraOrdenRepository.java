package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenPK;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;

public interface InfoExtraOrdenRepository extends JpaRepository<InfoExtraOrden, InfoExtraOrdenPK> {

    @Query(value = "SELECT * FROM Info_Extra_Orden", nativeQuery = true)
    Collection<InfoExtraOrden> getAllInfoExtraOrden();

    @Query(value = "SELECT * FROM Info_Extra_Orden WHERE Codigo_Barras_Producto = :codBar AND Id_Orden_Compra = :idOrdCom", nativeQuery = true)
    InfoExtraOrden getInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom);

    @Query(value = "SELECT * FROM Info_Extra_Orden WHERE Id_Orden_Compra = :idOrdCom", nativeQuery = true)
    Collection<InfoExtraOrden> getInfoExtraOrdenpororden( @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (:codBar, :idOrdCom, :cantidad, :costo)", nativeQuery = true)
    void insertInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom, @Param("cantidad") Integer cant,
                    @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Info_Extra_Orden SET Codigo_Barras_Producto = :codBarAct, Id_Orden_Compra = :idOrdComAct, Cantidad = :cantidad, Costo_Unitario_Compra = :costo WHERE Codigo_Barras_Producto = :codBar AND Id_Orden_Compra = :idOrdCom", nativeQuery = true)
    void updateInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom, 
    @Param("codBarAct") Long codBarAct, @Param("idOrdComAct") Long idOrdComAct, @Param("cantidad") Integer cant,
    @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Info_Extra_Orden WHERE Codigo_Barras_Producto = :codBar AND Id_Orden_Compra = :idOrdCom", nativeQuery = true)
    void deleteInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrd);
}
