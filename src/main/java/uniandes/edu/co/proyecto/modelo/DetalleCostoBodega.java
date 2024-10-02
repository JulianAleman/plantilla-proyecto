package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_Costo_Bodega")
public class DetalleCostoBodega {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Detalle_Costo_Bodega_seq")
    @SequenceGenerator(name = "Detalle_Costo_Bodega_seq", sequenceName = "Detalle_Costo_Bodega_seq", allocationSize = 1)
    private Long Id;
    
    private Double CostoUnitarioBodega;
    private Integer CantidadExistencias;
    public DetalleCostoBodega() {;
    }
    public DetalleCostoBodega(Double costoUnitarioBodega, Integer cantidadExistencias) {
        this.CostoUnitarioBodega = costoUnitarioBodega;
        this.CantidadExistencias = cantidadExistencias;
    }

    public Double getCostoUnitarioBodega() {
        return CostoUnitarioBodega;
    }

    public void setCostoUnitarioBodega(Double costoUnitarioBodega) {
        this.CostoUnitarioBodega = costoUnitarioBodega;
    }

    public Integer getCantidadExistencias() {
        return CantidadExistencias;
    }

    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.CantidadExistencias = cantidadExistencias;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }
    @Override
    public String toString() {
        return this.CostoUnitarioBodega + "|" + this.CantidadExistencias ;
    }
    
}
