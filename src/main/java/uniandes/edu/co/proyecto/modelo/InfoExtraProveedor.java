package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Proveedor")
public class InfoExtraProveedor {
    
    @EmbeddedId
    private InfoExtraProveedorPK pk;

    public InfoExtraProveedor() { ;
    }
    public InfoExtraProveedor(Proveedor nit, Producto codBar) {
        this.pk = new InfoExtraProveedorPK(nit, codBar);
    }


    public InfoExtraProveedorPK getPk() {
        return pk;
    }

    public void setPk(InfoExtraProveedorPK pk) {
        this.pk = pk;
    }
        
}
