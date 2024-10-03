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

    public interface ProductoInfo {
        String getNombreProducto();
        Long getCodigoBarras();
        String getBodega();
        String getSucursal();
        String getProveedor();
        Integer getTotalExistencia(); 
    }
    public interface ProductoImportante {

        String getNombre();
        Integer getCantidadActual();
        Integer getCantidadMinima();
        Double getCostoPromedio();
    }

    @Query(value = "SELECT * FROM Producto", nativeQuery = true)
    Collection<Producto> getAllProductos();

    @Query(value = "SELECT * FROM Producto WHERE Codigo_Barras = :codBar", nativeQuery = true)
    Producto getProducto(@Param("codBar") Long codBar);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Cantidad_Presentacion, Unidad_Medida, Fecha_Expiracion, Codigo_Categoria, Id_especificacion_Empacado) VALUES (producto_seq.nextval, :nombre, :precio, :presentacion, :cantidad, :unidadMedida, :expiracion, :codCategoria, :idEspecificacion)", nativeQuery = true)
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

    @Query(value = "Select p.* \r\n"+
        "From Producto p\r\n"+
        "INNER JOIN Producto_Perecedero pp ON p.codigo_barras = pp.codigo_barras_producto \r\n"+
        "INNER JOIN Categoria c ON p.codigo_categoria = c.codigo \r\n"+
        "INNER JOIN Info_Extra_Bodega ieb ON p.Codigo_Barras = ieb.codigo_barras_producto \r\n"+
        "INNER JOIN Bodega b ON ieb.id_bodega = b.id \r\n"+
        "INNER JOIN Sucursal s ON b.id_sucursal = s.id \r\n"+
        "WHERE Precio_Unitario_Venta BETWEEN :precioMinimo AND :precioMaximo\r\n"+
        "AND pp.fecha_vencimiento > :fechaVencimiento \r\n"+ 
        "AND (s.id= :sucursal OR c.codigo= :codigoCategoria);", nativeQuery = true)
    Collection<Producto> ProductosConCaracteristicas(@Param("sucursal") Long sucursal, 
                           @Param("precioMinimo") Double precioMinimo, 
                           @Param("precioMaximo") Double precioMaximo, 
                           @Param("fechaVencimiento") Date fechaVencimiento, 
                           @Param("codigoCategoria") Long codigoCategoria);

    @Query(value = "SELECT p.nombre, dcb.cantidad_Existencias AS CantidadActual, \r\n"+
                    "ieb.nivel_Minimo_Re_Orden AS CantidadMinima, ieb.costo_Promedio \r\n"+
                    "FROM Producto p \r\n"+
                    "INNER JOIN Info_Extra_Bodega ieb ON p.codigo_barras = ieb.codigo_barras_producto \r\n"+
                    "INNER JOIN Detalle_Costo_Bodega dcb ON ieb.id_detalle_costo_bodega = dcb.id \r\n"+
                    "WHERE ieb.id_bodega IN (SELECT b.id \r\n"+
                    "FROM Bodega b \r\n"+
                    "INNER JOIN Sucursal s ON b.id_sucursal = s.id \r\n"+
                    "WHERE b.id = :bodega AND s.id = :sucursal) \r\n", nativeQuery = true)
    Collection<ProductoImportante> obtenerDatosProducto(@Param("bodega") Long bodega, 
                                            @Param("sucursal") Long sucursal);

    @Query(value = "SELECT p.nombre, dcb.cantidad_Existencias AS CantidadActual, \r\n"+
                    "ieb.nivel_Minimo_Re_Orden AS CantidadMinima, ieb.costo_Promedio \r\n"+
                    "FROM Producto p \r\n"+
                    "INNER JOIN Info_Extra_Bodega ieb ON p.codigo_barras = ieb.codigo_barras_producto \r\n"+
                    "INNER JOIN Detalle_Costo_Bodega dcb ON ieb.id_detalle_costo_bodega = dcb.id \r\n"+
                    "WHERE ieb.id_bodega IN (SELECT b.id \r\n"+
                    "FROM Bodega b \r\n"+
                    "INNER JOIN Sucursal s ON b.id_sucursal = s.id) \r\n", nativeQuery = true)
    Collection<ProductoImportante> obtenerDatosProducto1();


    @Query(value = "SELECT p.Nombre AS nombreProducto, \r\n" +
                    "p.Codigo_Barras,\r\n" +
                    "b.nombre AS bodega,\r\n" +
                    "s.Nombre AS sucursal,\r\n" +
                    "pr.Nombre AS proveedor,\r\n" +
                    "ieb.Total_Existencia \r\n" +
                    "FROM Producto p \r\n" + 
                    "INNER JOIN Info_Extra_Bodega ieb ON p.Codigo_Barras = ieb.Codigo_Barras_Producto \r\n" + 
                    "INNER JOIN Detalle_Costo_Bodega dcb ON ieb.Id_Detalle_Costo_Bodega= dcb.id\r\n" + 
                    "INNER JOIN Bodega b ON ieb.id_bodega = b.id \r\n" + 
                    "INNER JOIN Sucursal s ON b.id_sucursal = s.id\r\n" + 
                    "INNER JOIN Info_Extra_Proveedor iep ON p.Codigo_Barras = iep.Codigo_Barras_Producto \r\n" + 
                    "INNER JOIN Proveedor pr ON iep.Nit_Proveedor = pr.Nit \r\n" + 
                    "WHERE ieb.Nivel_Minimo_Re_Orden> dcb.Cantidad_Existencias", nativeQuery = true)
     Collection<ProductoInfo> findProductosConBodegaYProveedor();
}