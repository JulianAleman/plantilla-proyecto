package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodigoBarras;

    private String Nombre;
    private Double Precio_Unitario_Venta;
    private String Presentacion;
    private Integer Cantidad_Presentacion;
    private String Unidad_Medida;
    private Date Fecha_Expiracion;

    @ManyToOne
    @JoinColumn(name = "Codigo_Categoria", referencedColumnName = "Codigo")
    private Categoria Codigo_categoria;

    @ManyToOne
    @JoinColumn(name = "Id_Especificacion_Empacado", referencedColumnName = "Id")
    private EspecificacionEmpacado Especificacion_Empacado;

    public Producto() {;}

    public Producto(String nombre, Double precioUnitarioVenta, String presentacion,
            Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, Categoria categoria,
            EspecificacionEmpacado especificacionEmpacado) {
        this.Nombre = nombre;
        this.Precio_Unitario_Venta = precioUnitarioVenta;
        this.Presentacion = presentacion;
        this.Cantidad_Presentacion = cantidadPresentacion;
        this.Unidad_Medida = unidadMedida;
        this.Fecha_Expiracion = fechaExpiracion;
        this.Codigo_categoria = categoria;
        this.Especificacion_Empacado = especificacionEmpacado;
    }

    
    public Long getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.CodigoBarras = codigoBarras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public Double getPrecioUnitarioVenta() {
        return Precio_Unitario_Venta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.Precio_Unitario_Venta = precioUnitarioVenta;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.Presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return Cantidad_Presentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.Cantidad_Presentacion = cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return Unidad_Medida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.Unidad_Medida = unidadMedida;
    }

    public Date getFechaExpiracion() {
        return Fecha_Expiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.Fecha_Expiracion = fechaExpiracion;
    }

    public Categoria getCodigo_categoria() {
        return Codigo_categoria;
    }

    public void setCodigo_categoria(Categoria categoria) {
        this.Codigo_categoria = categoria;
    }

    public EspecificacionEmpacado getId_EspecificacionEmpacado() {
        return Especificacion_Empacado;
    }

    public void setId_EspecificacionEmpacado(EspecificacionEmpacado especificacionEmpacado) {
        this.Especificacion_Empacado = especificacionEmpacado;
    }
    @Override
    public String toString() {
        return this.Nombre + "|" + this.Presentacion + "|"+ this.Cantidad_Presentacion + "|" + Unidad_Medida + "|" + Fecha_Expiracion +"|"+ Codigo_categoria+"|"+ Especificacion_Empacado;
    }
}
