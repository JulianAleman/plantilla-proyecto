package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EspecificacionEmpacado")
public class EspecificacionEmpacado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    
    private Double Volumen_cm3;
    private Double Peso_Gr;
    public EspecificacionEmpacado() {;
    }
    public EspecificacionEmpacado(Double volumen_CM3, Double peso_Gr) {
        this.Volumen_cm3 = volumen_CM3;
        this.Peso_Gr = peso_Gr;
    }



    public Double getVolumen_CM3() {
        return Volumen_cm3;
    }

    public void setVolumen_CM3(Double volumen_CM3) {
        this.Volumen_cm3 = volumen_CM3;
    }

    public Double getPeso_Gr() {
        return Peso_Gr;
    }

    public void setPeso_Gr(Double peso_Gr) {
        this.Peso_Gr = peso_Gr;
    }

    public Long getId() {
        return Id;
    }
        

}
