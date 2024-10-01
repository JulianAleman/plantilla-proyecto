package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RecepcionProductos;

public interface RecepcionProductosRepository extends JpaRepository<RecepcionProductos, Long> {

    @Query(value = "SELECT * FROM RecepcionProductos", nativeQuery = true)
    Collection<RecepcionProductos> getAllRecepcionProductos();

    @Query(value = "SELECT * FROM RecepcionProductos WHERE Id = :id", nativeQuery = true)
    RecepcionProductos getRecepcionProductos(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RecepcionProductos (Id, fechaRecepcion, Id_Bodega, Id_ordenCompra) VALUES (proyecto-1-superandes_sequence.nextval, :recepcion, :idBodega, :idOrdCom)", nativeQuery = true)
    void insertRecepcionProductos(@Param("recepcion") Date recepcion, @Param("idBodega") Long idBodega, 
                                @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "UPDATE RecepcionProductos SET fechaRecepcion = :recepcion, Id_Bodega = :idbodega, Id_ordenCompra = :idOrdCom WHERE Id = :id", nativeQuery = true)
    void updateRecepcionProductos(@Param("id") Long id, @Param("recepcion") Date recepcion, 
                                @Param("idbodega") Long idBodega, @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RecepcionProductos WHERE Id = :id", nativeQuery = true)
    void deleteRecepcionProductos(@Param("id") Long id);
}
