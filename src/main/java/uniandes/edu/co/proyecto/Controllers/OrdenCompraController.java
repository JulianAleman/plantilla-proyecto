package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.Repositories.OrdenCompraRepository;

@RestController
public class OrdenCompraController {
    
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @GetMapping("/OrdenesCompra")
    public Collection<OrdenCompra> getAllOrdenesCompra() {
        return ordenCompraRepository.getAllOrdenCompras();
    }

    @PostMapping("/OrdenesCompra/new/save")
    public ResponseEntity<String> OrdenesCompraGuardar(@RequestBody OrdenCompra ordenCompra) {
        try {
            ordenCompraRepository.insertOrdenCompra(ordenCompra.getFechaCreacion(), ordenCompra.getEstado(), ordenCompra.getFechaEntrega(), 
                                            ordenCompra.getNit_proveedor().getNIT(), ordenCompra.getId_Sucursal().getId());
        
        return new ResponseEntity<>("OrdenCompra creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el OrdenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
