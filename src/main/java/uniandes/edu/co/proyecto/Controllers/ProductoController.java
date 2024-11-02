package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import java.util.HashMap;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.Repositories.ProductoRepository;
import uniandes.edu.co.proyecto.Repositories.ProductoRepository.ProductoImportante;
import uniandes.edu.co.proyecto.Repositories.ProductoRepository.ProductoInfo;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/Productos")
    public ResponseEntity<Collection<Producto>> getAllProductos() {
        try{
            Collection<Producto>pr =productoRepository.getAllProductos();
            return ResponseEntity.ok(pr);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    @PutMapping("/Productos/Update")
    public ResponseEntity<String> ActualizarEstado(@RequestParam Long codBar, @RequestParam String cantidad)  {
        try {
            productoRepository.updateProducto(codBar, cantidad);
        return new ResponseEntity<>("OrdenCompra Actualizada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al actualizar la OrdenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    @GetMapping("/Productos/codigo")
    public ResponseEntity<Producto> getProductoByCodigo(@RequestParam Long codigo) {
    try {
        Producto categoria = productoRepository.getProducto(codigo);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }
    @GetMapping("/Productos/Consulta/OrdenCompra")
    public ResponseEntity<Collection<ProductoInfo>> ProductosNeedOrdenCompra() {
        try{
            Collection<ProductoInfo>pr =productoRepository.findProductosConBodegaYProveedor();
            return ResponseEntity.ok(pr);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/Producto/ConsultaC")
    public ResponseEntity<?> getProductosEspecificaciones(@RequestParam(required = false) Long sucursal, 
                           @RequestParam(required = false) Double precioMinimo, 
                           @RequestParam(required = false) Double precioMaximo, 
                           @RequestParam(required = false) String fechaVencimiento, 
                           @RequestParam(required = false) Long codigoCategoria) {
        
        try{
            Map<String, Object> response = new HashMap<>();
            Collection<Producto> productos;
            if (sucursal == null || precioMinimo == null || precioMaximo == null || 
            fechaVencimiento == null || codigoCategoria == null ||fechaVencimiento.isEmpty() ) {
                productos = productoRepository.getAllProductos();

            } else {
                productos = productoRepository.ProductosConCaracteristicas(sucursal, precioMinimo, precioMaximo,fechaVencimiento, codigoCategoria);
            }
            response.put("Productos", productos);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    @GetMapping("/Producto/ConsultaI")
    public ResponseEntity<?> getProductosEspecificaciones(@RequestParam(required = false) Long bodega, @RequestParam(required = false) Long sucursal) {
        
        try{
            Map<String, Object> response = new HashMap<>();
            Collection<ProductoImportante> productos;
            if (sucursal == null || bodega == null  ) {
                productos = productoRepository.obtenerDatosProducto1();

            } else {
                productos = productoRepository.obtenerDatosProducto(bodega, sucursal);
            }
            response.put("Productos", productos);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
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
