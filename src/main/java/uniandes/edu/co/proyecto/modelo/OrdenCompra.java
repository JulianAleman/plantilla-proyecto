package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orden_Compra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orden_Compra_seq")
    @SequenceGenerator(name = "Orden_Compra_seq", sequenceName = "Orden_Compra_seq", allocationSize = 1)
    private Long Id;

    private Date FechaCreacion;
    private String Estado;
    private Date FechaEntrega;

    @ManyToOne
    @JoinColumn(name = "Nit_proveedor", referencedColumnName = "Nit")
    private Proveedor Nit_proveedor;

    @OneToOne
    @JoinColumn(name = "Id_Sucursal", referencedColumnName = "Id")
    private Sucursal Id_Sucursal;
    public OrdenCompra() {;
    }
    public OrdenCompra(Date fechaCreacion, String estado, Date fechaEntrega, Proveedor nit_proveedor,
            Sucursal id_Sucursal) {
        this.FechaCreacion = fechaCreacion;
        this.Estado = estado;
        this.FechaEntrega = fechaEntrega;
        this.Nit_proveedor = nit_proveedor;
        this.Id_Sucursal = id_Sucursal;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.FechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.FechaEntrega = fechaEntrega;
    }

    public Proveedor getNit_proveedor() {
        return Nit_proveedor;
    }

    public void setNit_proveedor(Proveedor nit_proveedor) {
        Nit_proveedor = nit_proveedor;
    }

    public Sucursal getId_Sucursal() {
        return Id_Sucursal;
    }

    public void setId_Sucursal(Sucursal id_Sucursal) {
        Id_Sucursal = id_Sucursal;
    }
    
}
