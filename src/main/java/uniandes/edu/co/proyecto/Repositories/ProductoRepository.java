package uniandes.edu.co.proyecto.Repositories;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM Producto", nativeQuery = true)
    Collection<Producto> getAllProductos();

    @Query(value = "SELECT * FROM Producto WHERE CodigoBarras = :codBar", nativeQuery = true)
    Producto getProducto(@Param("codBar") Long codBar);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Cantidad_Presentacion, Unidad_Medida, Fecha_Expiracion, Codigo_Categoria, Id_especificacion_Empacado) VALUES (proyecto-1-superandes_sequence.nextval, :nombre, :precio, :presentacion, :cantidad, :unidadMedida, :expiracion, :codCategoria, :idEspecificacion)", nativeQuery = true)
    void insertProducto(@Param("nombre") String nombre, @Param("precio") Double precio, @Param("presentacion") String presentacion,
                        @Param("cantidad") Integer cantidad, @Param("unidadMedida") String unidadMedida, 
                        @Param("expiracion") Date expiracion, @Param("codCategoria") Long codCategoria, @Param("idEspecificacion") Long idEspecificacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Producto SET Nombre = :nombre, Precio_Unitario_Venta = :precio, Cantidad_Presentacion = :presentacion, Unidad_Medida = :unidadMedida, Fecha_Expiracion = :expiracion, Codigo_Categoria = :codCategoria, Id_especificacion_Empacado = :idEspecificacion WHERE CodigoBarras = :codBar", nativeQuery = true)
    void updateProducto(@Param("codBar") Long codBar, @Param("nombre") String nombre, @Param("precio") Double precio, @Param("presentacion") String presentacion,
    @Param("unidadMedida") String unidadMedida, 
    @Param("expiracion") Date expiracion, @Param("codCategoria") Long codCategoria, 
    @Param("idEspecificacion") Long idEspecificacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Producto WHERE Codigo_Barras = :codBar", nativeQuery = true)
    void deleteProducto(@Param("codBar") Long codBar);

}
