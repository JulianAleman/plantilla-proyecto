package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraVenta;
import uniandes.edu.co.proyecto.modelo.InfoExtraVentaPK;

public interface InfoExtraVentaRepository extends JpaRepository<InfoExtraVenta, InfoExtraVentaPK> {

    @Query(value = "SELECT * FROM Info_Extra_Venta", nativeQuery = true)
    Collection<InfoExtraVenta> getAllInfoExtraVenta();

    @Query(value = "SELECT * FROM Info_Extra_Venta WHERE Codigo_Barras_Producto = :codBar AND Id_Venta = :idVenta", nativeQuery = true)
    InfoExtraVenta getInfoExtraVenta(@Param("codBar") Long codBar, @Param("idVenta") Long idVenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (:codBar, :idVenta, :cantidad, :precio)", nativeQuery = true)
    void insertInfoExtraVenta(@Param("codBar") Long codBar, @Param("idVenta") Long idVenta, @Param("cantidad") Integer cantidad,
                    @Param("precio") Double precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Info_Extra_Venta SET Codigo_Barras_Producto = :codBarAct, Id_Venta = :idVentaAct, Cantidad = :cantidad, Precio_Unitario_Venta = :precio WHERE Codigo_Barras_Producto = :codBar AND Id_Venta = :idVenta", nativeQuery = true)
    void updateInfoExtraVenta(@Param("codBarAct") Long codBarAct, @Param("idVentaAct") Long idVentaAct, 
    @Param("codBar") Long codBar, @Param("idVenta") Long idVenta, @Param("cantidad") Integer cantidad,
    @Param("precio") Double precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Info_Extra_Venta WHERE CodigoBarras_Producto = :codBar AND Id_Venta = :idVenta", nativeQuery = true)
    void deleteInfoExtraVenta(@Param("codBar") Long codBar, @Param("idVenta") Long idVenta);
}
