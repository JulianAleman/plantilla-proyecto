package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Venta")
public class InfoExtraVenta {
    
    @EmbeddedId
    private InfoExtraVentaPK pk;
    public InfoExtraVenta() {;
    }
    public InfoExtraVenta(Producto codigoBarras, Venta idVenta, Integer cantidad, Double precio){
        this.pk = new InfoExtraVentaPK(codigoBarras, idVenta, cantidad, precio);
    }


    public InfoExtraVentaPK getPk() {
        return pk;
    }

    public void setPk(InfoExtraVentaPK pk) {
        this.pk = pk;
    }
        
}
