package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    @Query(value = "SELECT * FROM Sucursal", nativeQuery = true)
    Collection<Sucursal> getAllSucursales();

    @Query(value = "SELECT * FROM Sucursal WHERE Id = :id", nativeQuery = true)
    Sucursal getSucursal(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, Telefono, codigo_Ciudad) VALUES (proyecto-1-superandes_sequence.nextval, :nombre, :tamanio, :direccion, :telefono, :codCiudad)", nativeQuery = true)
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
}