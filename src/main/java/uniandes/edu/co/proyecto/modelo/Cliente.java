package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    private Long Cedula;

    private String Nombre;
    public Cliente() {;
    }
    public Cliente(Long cedula, String nombre) {
        this.Cedula = cedula;
        this.Nombre = nombre;
    }

    

    public Long getCedula() {
        return Cedula;
    }

    public void setCedula(Long cedula) {
        this.Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
}
