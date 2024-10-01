package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Codigo;

    private String Nombre;

    private String Descripcion;
    
    private String Caracteristicas_Almacenamiento; 
    public Categoria() {;}

    public Categoria(String nombre, String descripcion, String CaracteristicasAlmacenamiento) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Caracteristicas_Almacenamiento=CaracteristicasAlmacenamiento;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getCaracteristicasAlmacenamiento() {
        return Caracteristicas_Almacenamiento;
    }

    public void setCaracteristicasAlmacenamiento(String caracteristicasAlmacenamiento) {
        this.Caracteristicas_Almacenamiento = caracteristicasAlmacenamiento;
    }
    @Override
    public String toString() {
        return this.Nombre + "|" + this.Descripcion + "|"+ this.Caracteristicas_Almacenamiento;
    }
}
