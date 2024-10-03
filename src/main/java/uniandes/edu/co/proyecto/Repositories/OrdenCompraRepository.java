package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    @Query(value = "SELECT * FROM Orden_Compra", nativeQuery = true)
    Collection<OrdenCompra> getAllOrdenCompras();

    @Query(value = "SELECT * FROM Orden_Compra WHERE Id = :id", nativeQuery = true)
    OrdenCompra getOrdenCompra(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_proveedor, Id_Sucursal) VALUES (proyecto-1-superandes_sequence.nextval, :creacion, :estado, :entrega, :nit, :idSucursal)", nativeQuery = true)
    void insertOrdenCompra(@Param("creacion") Date creacion, @Param("estado") String estado, @Param("entrega") Date entrega,
                        @Param("nit") Long nitProveedor, @Param("idSucursal") Long idSucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Orden_Compra SET Fecha_Creacion = :creacion, Estado = :estado, Fecha_Entrega = :entrega, Nit_proveedor = :nit, Id_Sucursal = :idSucursal WHERE Id = :id", nativeQuery = true)
    void updateOrdenCompra(@Param("id") Long id, @Param("creacion") Date creacion, @Param("estado") String estado, @Param("entrega") Date entrega,
    @Param("nit") Long nitProveedor, @Param("idSucursal") Long idSucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Orden_Compra WHERE Id = :id", nativeQuery = true)
    void deleteOrdenCompra(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenCompra (fecha_creacion, estado, fecha_entrega, nit_proveedor, id_sucursal) VALUES (:fechaCreacion, :estado, :fechaEntrega, :nitProveedor, :sucursalId)", nativeQuery = true)
    void insertOrdenCompra(@Param("fechaCreacion") String fechaCreacion, @Param("estado") String estado, @Param("fechaEntrega") String fechaEntrega, @Param("nitProveedor") String nitProveedor, @Param("sucursalId") Long sucursalId);
    
    @Modifying
    @Transactional
    @Query (value = "UPDATE OrdenCompra SET estado = 'vigente' WHERE id = :id", nativeQuery = true)
    void updateOrdenCompraEstado(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompra SET estado = 'anulada' WHERE id = :id AND estado = 'vigente'", nativeQuery = true)
    void anularOrdenCompra(@Param("id") Long id);
}
