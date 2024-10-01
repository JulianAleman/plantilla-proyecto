package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraProveedorPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "Nit_Proveedor", referencedColumnName = "NIT")
    private Proveedor Nit_Proveedor;

    @ManyToOne
    @JoinColumn(name = "CodigoBarras_Producto", referencedColumnName = "CodigoBarras")
    private Producto CodigoBarras_Producto;
    public InfoExtraProveedorPK(){
        super();
    }
    public InfoExtraProveedorPK(Proveedor nit, Producto codBar) {
        super();
        this.Nit_Proveedor = nit;
        this.CodigoBarras_Producto = codBar;
    }

    public Proveedor getNit() {
        return Nit_Proveedor;
    }

    public void setNit(Proveedor nit) {
        this.Nit_Proveedor = nit;
    }

    public Producto getCodBar() {
        return CodigoBarras_Producto;
    }

    public void setCodBar(Producto codBar) {
        this.CodigoBarras_Producto = codBar;
    }

}
