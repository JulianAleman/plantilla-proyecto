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
    private Double PrecioUnitarioVenta;
    private String Presentacion;
    private Integer CantidadPresentacion;
    private String UnidadMedida;
    private Date FechaExpiracion;

    @ManyToOne
    @JoinColumn(name = "Codigo_Categoria", referencedColumnName = "codigo")
    private Categoria Codigo_categoria;

    @ManyToOne
    @JoinColumn(name = "Id_especificacionEmpacado", referencedColumnName = "id")
    private EspecificacionEmpacado Id_EspecificacionEmpacado;
    public Producto() {;
    }
    public Producto(String nombre, Double precioUnitarioVenta, String presentacion,
            Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, Categoria categoria,
            EspecificacionEmpacado especificacionEmpacado) {
        this.Nombre = nombre;
        this.PrecioUnitarioVenta = precioUnitarioVenta;
        this.Presentacion = presentacion;
        this.CantidadPresentacion = cantidadPresentacion;
        this.UnidadMedida = unidadMedida;
        this.FechaExpiracion = fechaExpiracion;
        this.Codigo_categoria = categoria;
        this.Id_EspecificacionEmpacado = especificacionEmpacado;
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
        return PrecioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.PrecioUnitarioVenta = precioUnitarioVenta;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.Presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return CantidadPresentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.CantidadPresentacion = cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.UnidadMedida = unidadMedida;
    }

    public Date getFechaExpiracion() {
        return FechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.FechaExpiracion = fechaExpiracion;
    }

    public Categoria getCodigo_categoria() {
        return Codigo_categoria;
    }

    public void setCodigo_categoria(Categoria categoria) {
        this.Codigo_categoria = categoria;
    }

    public EspecificacionEmpacado getId_EspecificacionEmpacado() {
        return Id_EspecificacionEmpacado;
    }

    public void setId_EspecificacionEmpacado(EspecificacionEmpacado especificacionEmpacado) {
        this.Id_EspecificacionEmpacado = especificacionEmpacado;
    }
}
