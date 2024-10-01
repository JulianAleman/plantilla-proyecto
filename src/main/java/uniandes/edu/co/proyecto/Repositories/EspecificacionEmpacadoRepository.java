package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EspecificacionEmpacado;

public interface EspecificacionEmpacadoRepository extends JpaRepository<EspecificacionEmpacado, Long> {

    @Query(value = "SELECT * FROM EspecificacionEmpacado", nativeQuery = true)
    Collection<EspecificacionEmpacado> getAllEspecificacionEmpacado();

    @Query(value = "SELECT * FROM EspecificacionEmpacado WHERE Id = :id", nativeQuery = true)
    EspecificacionEmpacado getEspecificacionEmpacado(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EspecificacionEmpacado (Id, Volumen_Cm3, Peso_Gr) VALUES (proyecto-1-superandes_sequence.nextval, :volumen, :peso)", nativeQuery = true)
    void insertEspecificacionEmpacado(@Param("volumen") Double vol, @Param("peso") Double peso);

    @Modifying
    @Transactional
    @Query(value = "UPDATE EspecificacionEmpacado SET Volumen_Cm3 = :volumen, Peso_Gr = :peso WHERE Id = :id", nativeQuery = true)
    void updateEspecificacionEmpacado(@Param("id") Long id, @Param("volumen") Double vol, @Param("peso") Double peso);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EspecificacionEmpacado WHERE Id = :id", nativeQuery = true)
    void deleteEspecificacionEmpacado(@Param("id") Long id);
}
