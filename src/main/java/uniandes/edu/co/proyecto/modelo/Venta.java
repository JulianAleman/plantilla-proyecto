package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "venta_seq", allocationSize = 1)
    private Long Id;

    private Date Fecha;

    @ManyToOne
    @JoinColumn(name = "Id_Sucursal", referencedColumnName = "Id")
    private Sucursal Id_Sucursal;

    @OneToOne
    @JoinColumn(name = "Cedula_Cliente", referencedColumnName = "Cedula")
    private Cliente Cedula_Cliente;
    public Venta() { ;
    }
    public Venta( Date fecha, Sucursal id_Sucursal, Cliente id_Cliente) {
        this.Fecha = fecha;
        this.Id_Sucursal = id_Sucursal;
        this.Cedula_Cliente = id_Cliente;
    }

    

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        this.Fecha = fecha;
    }

    public Sucursal getId_Sucursal() {
        return Id_Sucursal;
    }

    public void setId_Sucursal(Sucursal id_Sucursal) {
        this.Id_Sucursal = id_Sucursal;
    }

    public Cliente getId_Cliente() {
        return Cedula_Cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.Cedula_Cliente = id_Cliente;
    }
}

