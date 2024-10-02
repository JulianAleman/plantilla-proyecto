package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    public interface SucursalInfo {
        String getNombre();
    }
    @Query(value = "SELECT * FROM Sucursal", nativeQuery = true)
    Collection<Sucursal> getAllSucursales();

    @Query(value = "SELECT * FROM Sucursal WHERE Id = :id", nativeQuery = true)
    Sucursal getSucursal(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, Telefono, codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, :nombre, :tamanio, :direccion, :telefono, :codCiudad)", nativeQuery = true)
    void insertSucursal(@Param("nombre") String nombre, @Param("tamanio") Double tam, @Param("direccion") String direccion,
                        @Param("telefono") Integer telefono, @Param("codCiudad") Long codCiudad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Sucursal SET Nombre = :nombre, Tamaño = :tamanio, Direccion = :direccion, Telefono = :telefono, codigo_Ciudad = :codCiudad WHERE Id = :id", nativeQuery = true)
    void updateSucursal(@Param("id") Long id, @Param("nombre") String nombre, @Param("tamanio") String tam, 
                        @Param("direccion") String direccion, @Param("telefono") Integer telefono, 
                        @Param("codCiudad") Long codCiudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Sucursal WHERE Id = :id", nativeQuery = true)
    void deleteSucursal(@Param("id") Long id);


    @Query(value="SELECT s.nombre \r\n"+ 
                    "FROM Sucursal s \r\n"+ 
                    "INNER JOIN Bodega b ON s.id= b.id_sucursal \r\n"+
                    "INNER JOIN Info_Extra_Bodega ieb ON b.id = ieb.id_bodega \r\n"+
                    "INNER JOIN Producto p ON ieb.codigo_barras_producto = p.codigo_barras \r\n"+
                    "INNER JOIN Detalle_Costo_Bodega dcb ON ieb.id_detalle_costo_bodega = dcb.id\r\n"+
                    "WHERE P.codigo_Barras = :producto AND dcb.cantidad_existencias>0", nativeQuery = true)
    Collection<SucursalInfo> SucursalesDeProducto(@Param("producto") Long producto);

    @Query(value="SELECT s.nombre \r\n"+ 
    "FROM Sucursal s ", nativeQuery = true)
Collection<SucursalInfo> SucursalesDeProducto1();
}