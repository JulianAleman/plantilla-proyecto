package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String Nombre;
    private Double Tamaño;

    @ManyToOne
    @JoinColumn(name = "Id_sucursal", referencedColumnName = "Id")
    private Sucursal Id_sucursal;

    
    public Bodega() 
    {;}
    public Bodega(String nombre, Double tamanio, Sucursal sucursal) {
        this.Nombre = nombre;
        this.Tamaño = tamanio;
        //this.Id_sucursal = sucursal;
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

    //public Sucursal getSucursal() {
    //    return Id_sucursal;
    //}

    //public void setSucursal(Sucursal sucursal) {
    //    this.Id_sucursal = sucursal;
    //}
}
