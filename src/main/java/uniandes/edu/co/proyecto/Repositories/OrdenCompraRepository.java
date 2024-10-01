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

    @Query(value = "SELECT * FROM OrdenCompra", nativeQuery = true)
    Collection<OrdenCompra> getAllOrdenCompras();

    @Query(value = "SELECT * FROM OrdenCompra WHERE Id = :id", nativeQuery = true)
    OrdenCompra getOrdenCompra(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenCompra (Id, FechaCreacion, Estado, FechaEntrega, Nit_proveedor, Id_Sucursal) VALUES (proyecto-1-superandes_sequence.nextval, :creacion, :estado, :entrega, :nit, :idSucursal)", nativeQuery = true)
    void insertOrdenCompra(@Param("creacion") Date creacion, @Param("estado") String estado, @Param("entrega") Date entrega,
                        @Param("nit") Long nitProveedor, @Param("idSucursal") Long idSucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompra SET FechaCreacion = :creacion, Estado = :estado, FechaEntrega = :entrega, Nit_proveedor = :nit, Id_Sucursal = :idSucursal WHERE Id = :id", nativeQuery = true)
    void updateOrdenCompra(@Param("id") Long id, @Param("creacion") Date creacion, @Param("estado") String estado, @Param("entrega") Date entrega,
    @Param("nit") Long nitProveedor, @Param("idSucursal") Long idSucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenCompra WHERE Id = :id", nativeQuery = true)
    void deleteOrdenCompra(@Param("id") Long id);
}
