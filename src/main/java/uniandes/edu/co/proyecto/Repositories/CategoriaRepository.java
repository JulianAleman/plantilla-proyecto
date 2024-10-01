package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM Categoria", nativeQuery = true)
    Collection<Categoria> getCategorias();

    @Query(value = "SELECT * FROM Categoria WHERE Codigo = :id", nativeQuery = true)
    Categoria getCategoria(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Categoria (Codigo, Nombre, Descripcion, CaracteristicasAlmacenamiento) VALUES (proyecto-1-superandes_sequence.nextval, :nombre, :descripcion, :caractAlmacena)", nativeQuery = true)
    void insertCategoria(@Param("nombre") String nombre, @Param("descripcion") String desc, @Param("caractAlmacena") String caractAlmacena);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Categoria SET Nombre = :nombre, Descripcion = :desc, CaracteristicasAlmacena = :caractAlmacena WHERE Codigo = :id", nativeQuery = true)
    void updateCategoria(@Param("id") Long id, @Param("nombre") String nombre, @Param("desc") String desc, @Param("caractAlmacena") String caractAlmacena);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Categoria WHERE Codigo = :id", nativeQuery = true)
    void deleteCategoria(@Param("id") Long id);
}
