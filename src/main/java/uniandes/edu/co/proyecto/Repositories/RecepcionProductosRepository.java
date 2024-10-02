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

    @Query(value = "SELECT * FROM Recepcion_Productos", nativeQuery = true)
    Collection<RecepcionProductos> getAllRecepcionProductos();

    @Query(value = "SELECT * FROM Recepcion_Productos WHERE Id = :id", nativeQuery = true)
    RecepcionProductos getRecepcionProductos(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_ordenCompra) VALUES (proyecto-1-superandes_sequence.nextval, :recepcion, :idBodega, :idOrdCom)", nativeQuery = true)
    void insertRecepcionProductos(@Param("recepcion") Date recepcion, @Param("idBodega") Long idBodega, 
                                @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Recepcion_Productos SET fecha_Recepcion = :recepcion, Id_Bodega = :idbodega, Id_orden_Compra = :idOrdCom WHERE Id = :id", nativeQuery = true)
    void updateRecepcionProductos(@Param("id") Long id, @Param("recepcion") Date recepcion, 
                                @Param("idbodega") Long idBodega, @Param("idOrdCom") Long idOrdCom);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Recepcion_Productos WHERE Id = :id", nativeQuery = true)
    void deleteRecepcionProductos(@Param("id") Long id);
}
