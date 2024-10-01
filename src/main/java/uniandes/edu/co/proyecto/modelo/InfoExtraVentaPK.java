package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraVentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CodigoBarras_Producto", referencedColumnName =  "CodigoBarras")
    private Producto CodigoBarras_Producto;

    @ManyToOne
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id")
    private Venta Id_venta;

    private Integer Cantidad;
    private Double PrecioUnitarioVenta;
    public InfoExtraVentaPK(){
        super();
    }
    public InfoExtraVentaPK(Producto codigoBarras, Venta id_venta, Integer cantidad, Double precioUnitarioVenta) {
        super();
        this.CodigoBarras_Producto = codigoBarras;
        this.Id_venta = id_venta;
        this.Cantidad = cantidad;
        this.PrecioUnitarioVenta = precioUnitarioVenta;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.Cantidad = cantidad;
    }

    public Double getPrecioUnitarioVenta() {
        return PrecioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.PrecioUnitarioVenta = precioUnitarioVenta;
    }

    public Producto getCodigoBarras() {
        return CodigoBarras_Producto;
    }

    public void setCodigoBarras(Producto codigoBarras) {
        this.CodigoBarras_Producto = codigoBarras;
    }

    public Venta getId_venta() {
        return Id_venta;
    }

    public void setId_venta(Venta id_venta) {
        this.Id_venta = id_venta;
    }
}
