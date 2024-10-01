package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DetalleCostoBodega")
public class DetalleCostoBodega {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
}
