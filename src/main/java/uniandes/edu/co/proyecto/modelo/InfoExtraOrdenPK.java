package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraOrdenPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CodigoBarras_Producto", referencedColumnName = "CodigoBarras")
    private Producto CodigoBarras_Producto;

    @ManyToOne
    @JoinColumn(name = "Id_ordenCompra", referencedColumnName = "Id")
    private OrdenCompra Id_ordenCompra;

    private Integer Cantidad;
    private Double CostoUnitarioCompra;
    public InfoExtraOrdenPK(){
        super();
    }
    public InfoExtraOrdenPK(Producto codigoBarras, OrdenCompra ordenCompra, Integer cantidad,
            Double costoUnitarioCompra) {
        super();
        this.CodigoBarras_Producto = codigoBarras;
        this.Id_ordenCompra = ordenCompra;
        this.Cantidad = cantidad;
        this.CostoUnitarioCompra = costoUnitarioCompra;
    }
 
    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.Cantidad = cantidad;
    }

    public Double getCostoUnitarioCompra() {
        return CostoUnitarioCompra;
    }

    public void setCostoUnitarioCompra(Double costoUnitarioCompra) {
        this.CostoUnitarioCompra = costoUnitarioCompra;
    }

    public Producto getCodigoBarras() {
        return CodigoBarras_Producto;
    }

    public void setCodigoBarras(Producto codigoBarras) {
        this.CodigoBarras_Producto = codigoBarras;
    }

    public OrdenCompra getOrdenCompra() {
        return Id_ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.Id_ordenCompra = ordenCompra;
    }
        
}
