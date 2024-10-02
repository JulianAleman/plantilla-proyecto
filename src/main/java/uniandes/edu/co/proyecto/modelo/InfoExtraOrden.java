package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Orden")
public class InfoExtraOrden {
    
    @EmbeddedId
    private InfoExtraOrdenPK pk;
    public InfoExtraOrden() { ;
    }
    public InfoExtraOrden(Producto codigoBarras, OrdenCompra ordenCompra, Integer cantidad,
    Double costoUnitarioCompra){
        this.pk = new InfoExtraOrdenPK(codigoBarras, ordenCompra, cantidad, costoUnitarioCompra);
    }

    

    public InfoExtraOrdenPK getPk() {
        return pk;
    }

    public void setPk(InfoExtraOrdenPK pk) {
        this.pk = pk;
    }

}
