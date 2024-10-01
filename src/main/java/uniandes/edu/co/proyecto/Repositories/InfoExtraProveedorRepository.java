package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraProveedor;
import uniandes.edu.co.proyecto.modelo.InfoExtraProveedorPK;

public interface InfoExtraProveedorRepository extends JpaRepository<InfoExtraProveedor, InfoExtraProveedorPK> {

    @Query(value = "SELECT * FROM InfoExtraProveedor", nativeQuery = true)
    Collection<InfoExtraProveedor> getAllInfoExtraProveedors();

    @Query(value = "SELECT * FROM InfoExtraProveedor WHERE Nit_Proveedor = :nit AND CodigoBarras_Producto = :codBar", nativeQuery = true)
    InfoExtraProveedor getInfoExtraProveedor(@Param("nit") Long nit, @Param("codBar") Long codBar);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO InfoExtraProveedor (Nit_Proveedor, CodigoBarras_Producto) VALUE (:nit, :codBar)", nativeQuery = true)
    void insertInfoExtraProveedor(@Param("nit") Long nit, @Param("codBar") Long codBar);

    @Modifying
    @Transactional
    @Query(value = "UPDATE InfoExtraProveedor SET Nit_Proveedor = :nitAct, CodigoBarras_Producto = :codBarAct WHERE Nit_Proveedor = :nit AND CodigoBarras_Producto = :codBar", nativeQuery = true)
    void updateInfoExtraProveedor(@Param("nit") Long nit, @Param("codBar") Long codBar, @Param("nitAct") Long nitAct, @Param("codBarAct") Long codBarAct);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM InfoExtraProveedor WHERE Nit_Proveedor = :nit AND CodigoBarras_Producto = :codBar", nativeQuery = true)
    void deleteInfoExtraProveedor(@Param("nit") Long nit, @Param("codBar") Long codBar);
}
