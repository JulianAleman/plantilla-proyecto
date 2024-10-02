package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_seq")
    @SequenceGenerator(name = "ciudad_seq", sequenceName = "ciudad_seq", allocationSize = 1)
    private Long Codigo;

    private String Nombre;
    public Ciudad() {;
    }
    public Ciudad(String nombre) {
        this.Nombre = nombre;
    }



    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long codigo) {
        this.Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
}
