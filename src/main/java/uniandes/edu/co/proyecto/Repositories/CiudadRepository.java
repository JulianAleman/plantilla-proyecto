package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    @Query(value = "SELECT * FROM Ciudad", nativeQuery = true)
    Collection<Ciudad> getCiudades();

    @Query(value = "SELECT * FROM Ciudad WHERE Codigo = :id", nativeQuery = true)
    Ciudad getCiudad(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ciudad (Codigo, Nombre) VALUES (proyecto-1-superandes_sequence.nextval, :nombre)", nativeQuery = true)
    void insertCiudad(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ciudad SET Nombre = :nombre WHERE Codigo = :id", nativeQuery = true)
    void updateCiudad(@Param("id") Long id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Ciudad WHERE Codigo = :id", nativeQuery = true)
    void deleteCiudad(@Param("id") Long id);
}
