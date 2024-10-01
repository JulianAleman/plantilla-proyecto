package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String Nombre;
    private Double Tamaño;
    private String Direccion;
    private Integer Telefono;
    public Sucursal() { ;
    }
    public Sucursal( String nombre, Double tamanio, String direccion, Integer telefono) {
        this.Nombre = nombre;
        this.Tamaño = tamanio;
        this.Direccion = direccion;
        this.Telefono = telefono;
    
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public Double getTamanio() {
        return Tamaño;
    }

    public void setTamanio(Double tamanio) {
        this.Tamaño = tamanio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        this.Telefono = telefono;
    }
}
