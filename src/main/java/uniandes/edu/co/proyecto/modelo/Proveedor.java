package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedor")
public class Proveedor {

    @Id
    private Long NIT;

    private String Nombre;
    private String Direccion;
    private String NombreContacto;
    private Long TelefonoContacto;
    public Proveedor() {;
    }
    public Proveedor(Long nIT, String nombre, String direccion, String nombreContacto, Long telefonoContacto) {
        this.NIT = nIT;
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.NombreContacto = nombreContacto;
        this.TelefonoContacto = telefonoContacto;
    }


    public Long getNIT() {
        return NIT;
    }

    public void setNIT(Long nIT) {
        NIT = nIT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.NombreContacto = nombreContacto;
    }

    public Long getTelefonoContacto() {
        return TelefonoContacto;
    }

    public void setTelefonoContacto(Long telefonoContacto) {
        this.TelefonoContacto = telefonoContacto;
    }

    

}
