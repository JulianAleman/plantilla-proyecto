package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.Repositories.OrdenCompraRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class OrdenCompraController {
    
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @GetMapping("/OrdenesCompra")
    public ResponseEntity<Collection<OrdenCompra>> getAllOrdenesCompra() {
        try{
            Collection<OrdenCompra> or =ordenCompraRepository.getAllOrdenCompras();
            return ResponseEntity.ok(or);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
    @PutMapping("/OrdenCompra/id")
    public ResponseEntity<String> ActualizarEstado(@RequestParam Long id) {
        
        try {
            ordenCompraRepository.anularOrdenCompra(id);
        return new ResponseEntity<>("OrdenCompra Actualizada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al actualizar la OrdenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
