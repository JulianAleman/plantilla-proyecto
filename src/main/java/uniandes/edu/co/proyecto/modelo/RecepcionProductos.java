package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Recepcion_Productos")
public class RecepcionProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recepcion_productos_seq")
    @SequenceGenerator(name = "recepcion_productos_seq", sequenceName = "recepcion_productos_seq", allocationSize = 1)
    private Long Id;

    private Date fechaRecepcion;

    @OneToOne
    @JoinColumn(name = "Id_Bodega", referencedColumnName = "Id")
    private Bodega Id_Bodega;

    @OneToOne
    @JoinColumn(name = "Id_OrdenCompra", referencedColumnName = "Id")
    private OrdenCompra Id_OrdenCompra;
    public RecepcionProductos() { ;
    }
    public RecepcionProductos(Date fechaRecepcion, Bodega id_Bodega, OrdenCompra id_OrdenCompra) {
        this.fechaRecepcion = fechaRecepcion;
        this.Id_Bodega = id_Bodega;
        this.Id_OrdenCompra = id_OrdenCompra;
    }
    


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Bodega getId_Bodega() {
        return Id_Bodega;
    }

    public void setId_Bodega(Bodega id_Bodega) {
        this.Id_Bodega = id_Bodega;
    }

    public OrdenCompra getId_OrdenCompra() {
        return Id_OrdenCompra;
    }

    public void setId_OrdenCompra(OrdenCompra id_OrdenCompra) {
        this.Id_OrdenCompra = id_OrdenCompra;
    }
}
