package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM Cliente", nativeQuery = true)
    Collection<Cliente> getClientes();

    @Query(value = "SELECT * FROM Cliente WHERE Cedula = :id", nativeQuery = true)
    Cliente getCliente(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cliente (Cedula, Nombre) VALUES (:cedula, :nombre)", nativeQuery = true)
    void insertCliente(@Param("cedula") Long ced, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cliente SET Nombre = :nombre WHERE Cedula = :id", nativeQuery = true)
    void updateCliente(@Param("id") Long id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cliente WHERE Cedula = :id", nativeQuery = true)
    void deleteCliente(@Param("id") Long id);
}
