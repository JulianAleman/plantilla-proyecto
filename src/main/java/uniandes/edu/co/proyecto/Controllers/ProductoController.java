package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.Repositories.ProductoRepository;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/Productos")
    public Collection<Producto> getAllProductos() {
        return productoRepository.getAllProductos();
    }

    @PostMapping("/Productos/new/save")
    public ResponseEntity<String> ProductoGuardar(@RequestBody Producto producto) {
        try {
            productoRepository.insertProducto(producto.getNombre(), producto.getPrecioUnitarioVenta(), producto.getPresentacion(),
                                        producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getFechaExpiracion(),
                                        producto.getCodigo_categoria().getCodigo(), producto.getId_EspecificacionEmpacado().getId());
        
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el Producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
