package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ProductoPerecederoPK {

    @OneToOne
    @JoinColumn(name = "Codigo_Barras_Producto", referencedColumnName = "CodigoBarras") // nombre de la columna en productos_perecederos, y la columna referenciada en productos
    private Producto Codigo_Barras_Producto;

    private String fecha_Vencimiento;

    public ProductoPerecederoPK(){
        super();
    }
    public ProductoPerecederoPK(Producto codigoBarras, String fecha_Vencimiento) {
        super();
        this.Codigo_Barras_Producto=codigoBarras;
        this.fecha_Vencimiento= fecha_Vencimiento;
    }

    public String getfecha() {
        return fecha_Vencimiento;
    }

    public void setfecha(String fecha) {
        this.fecha_Vencimiento = fecha;
    }
    public Producto getCodigo_Barras() {
        return Codigo_Barras_Producto;
    }

    public void setCodigo_Barras(Producto codigo) {
        this.Codigo_Barras_Producto = codigo;
    }

}
