package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class InfoExtraBodegaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CodigoBarras_Producto", referencedColumnName = "CodigoBarras")
    private Producto CodigoBarras_Producto;

    @ManyToOne
    @JoinColumn(name = "Id_Bodega", referencedColumnName = "Id")
    private Bodega Id_Bodega;

    @OneToOne
    @JoinColumn(name = "Id_detalleCostoBodega", referencedColumnName = "Id")
    private DetalleCostoBodega idCostobodega;

    private Integer TotalExistencia;
    private Double CostoPromedio;
    private Double CapacidadAlmacenamiento;
    private Double NivelMinimoReorden;

    public InfoExtraBodegaPK(){
        super();
    }
    public InfoExtraBodegaPK(Producto codBarras, Bodega idBodega, DetalleCostoBodega idCostobodega, Integer totalExistencia, Double costoPromedio,
            Double capacidadAlmacenamiento, Double nivelMinimoReorden) {
        super();
        this.CodigoBarras_Producto = codBarras;
        this.Id_Bodega = idBodega;
        this.TotalExistencia = totalExistencia;
        this.CostoPromedio = costoPromedio;
        this.CapacidadAlmacenamiento = capacidadAlmacenamiento;
        this.NivelMinimoReorden = nivelMinimoReorden;
    }

    public Integer getTotalExistencia() {
        return TotalExistencia;
    }

    public void setTotalExistencia(Integer totalExistencia) {
        this.TotalExistencia = totalExistencia;
    }

    public Double getCostoPromedio() {
        return CostoPromedio;
    }

    public void setCostoPromedio(Double costoPromedio) {
        this.CostoPromedio = costoPromedio;
    }

    public Double getCapacidadAlmacenamiento() {
        return CapacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(Double capacidadAlmacenamiento) {
        this.CapacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public Double getNivelMinimoReorden() {
        return NivelMinimoReorden;
    }

    public void setNivelMinimoReorden(Double nivelMinimoReorden) {
        this.NivelMinimoReorden = nivelMinimoReorden;
    }

    public Producto getCodBarras() {
        return CodigoBarras_Producto;
    }

    public void setCodBarras(Producto codBarras) {
        this.CodigoBarras_Producto= codBarras;
    }

    public Bodega getIdBodega() {
        return Id_Bodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.Id_Bodega = idBodega;
    }

}
