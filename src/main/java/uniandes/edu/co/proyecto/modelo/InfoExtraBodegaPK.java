package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class InfoExtraBodegaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Codigo_Barras_Producto", referencedColumnName = "CodigoBarras")
    private Producto Codigo_Barras_Producto;

    @ManyToOne
    @JoinColumn(name = "Id_Bodega", referencedColumnName = "Id")
    private Bodega Id_Bodega;

    @OneToOne
    @JoinColumn(name = "Id_detalle_Costo_Bodega", referencedColumnName = "Id")
    private DetalleCostoBodega idCostobodega;

    private Integer Total_Existencia;
    private Double Costo_Promedio;
    private Double Capacidad_Almacenamiento;
    private Double Nivel_Minimo_Re_orden;

    public InfoExtraBodegaPK(){
        super();
    }
    public InfoExtraBodegaPK(Producto codBarras, Bodega idBodega, DetalleCostoBodega idCostobodega, Integer totalExistencia, Double costoPromedio,
            Double capacidadAlmacenamiento, Double nivelMinimoReorden) {
        super();
        this.Codigo_Barras_Producto = codBarras;
        this.Id_Bodega = idBodega;
        this.Total_Existencia = totalExistencia;
        this.Costo_Promedio = costoPromedio;
        this.Capacidad_Almacenamiento = capacidadAlmacenamiento;
        this.Nivel_Minimo_Re_orden = nivelMinimoReorden;
    }

    public Integer getTotalExistencia() {
        return Total_Existencia;
    }

    public void setTotalExistencia(Integer totalExistencia) {
        this.Total_Existencia = totalExistencia;
    }

    public Double getCostoPromedio() {
        return Costo_Promedio;
    }

    public void setCostoPromedio(Double costoPromedio) {
        this.Costo_Promedio = costoPromedio;
    }

    public Double getCapacidadAlmacenamiento() {
        return Capacidad_Almacenamiento;
    }

    public void setCapacidadAlmacenamiento(Double capacidadAlmacenamiento) {
        this.Capacidad_Almacenamiento = capacidadAlmacenamiento;
    }

    public Double getNivelMinimoReorden() {
        return Nivel_Minimo_Re_orden;
    }

    public void setNivelMinimoReorden(Double nivelMinimoReorden) {
        this.Nivel_Minimo_Re_orden = nivelMinimoReorden;
    }

    public Producto getCodBarras() {
        return Codigo_Barras_Producto;
    }

    public void setCodBarras(Producto codBarras) {
        this.Codigo_Barras_Producto= codBarras;
    }

    public Bodega getIdBodega() {
        return Id_Bodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.Id_Bodega = idBodega;
    }

}
