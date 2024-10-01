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

    @Query(value = "SELECT * FROM InfoExtraOrden", nativeQuery = true)
    Collection<InfoExtraOrden> getAllInfoExtraOrden();

    @Query(value = "SELECT * FROM InfoExtraOrden WHERE CodigoBarras_Producto = :codBar AND Id_OrdenCompra = :idOrdCom", nativeQuery = true)
    InfoExtraOrden getInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO InfoExtraOrden (CodigoBarras_Producto, Id_OrdenCompra, Cantidad, CostoUnitarioCompra) VALUES (:codBar, :idOrdCom, :cantidad, :costo)", nativeQuery = true)
    void insertInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom, @Param("cantidad") Integer cant,
                    @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE InfoExtraOrden SET CodigoBarras_Producto = :codBarAct, Id_OrdenCompra = :idOrdComAct, Cantidad = :cantidad, CostoUnitarioCompra = :costo WHERE CodigoBarras_Producto = :codBar AND Id_OrdenCompra = :idOrdCom", nativeQuery = true)
    void updateInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrdCom, 
    @Param("codBarAct") Long codBarAct, @Param("idOrdComAct") Long idOrdComAct, @Param("cantidad") Integer cant,
    @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM InfoExtraOrden WHERE CodigoBarras_Producto = :codBar AND Id_OrdenCompra = :idOrdCom", nativeQuery = true)
    void deleteInfoExtraOrden(@Param("codBar") Long codBar, @Param("idOrdCom") Long idOrd);
}
