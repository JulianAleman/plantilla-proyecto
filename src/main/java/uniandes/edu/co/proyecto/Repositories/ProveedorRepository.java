package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query(value = "SELECT * FROM Proveedor", nativeQuery = true)
    Collection<Proveedor> getAllProveedores();

    @Query(value = "SELECT * FROM Proveedor WHERE Nit = :nit", nativeQuery = true)
    Proveedor getProveedor(@Param("nit") Long nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES (:nit, :nombre, :direccion, :contacto, :telefono)", nativeQuery = true)
    void insertProveedor(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("direccion") String direccion,
                        @Param("contacto") String contacto, @Param("telefono") Long telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Proveedor SET Nombre_Contacto = :contacto WHERE Nit = :nit", nativeQuery = true)
    void updateProveedor(@Param("nit") Long nit,@Param("contacto") String contacto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Proveedor WHERE Nit = :nit", nativeQuery = true)
    void deleteProveedor(@Param("nit") Long nit);
}
