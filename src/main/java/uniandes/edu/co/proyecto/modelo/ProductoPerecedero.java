package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Producto_Perecedero")
public class ProductoPerecedero {
    @EmbeddedId
    private  ProductoPerecederoPK pk;

    public ProductoPerecedero() { ;
    }
    public ProductoPerecedero(Producto codBar, String fecha_vencimiento) {
        this.pk = new ProductoPerecederoPK(codBar, fecha_vencimiento);
    }


}
