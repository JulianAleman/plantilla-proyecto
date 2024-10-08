package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.RecepcionProductos;
import uniandes.edu.co.proyecto.Repositories.RecepcionProductosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RecepcionProductosController {
    
    @Autowired
    private RecepcionProductosRepository recepcionProductosRepository;

    @GetMapping("/RecepcionProductos")
    public ResponseEntity<Collection<RecepcionProductos>> getAllRecepcionProductos() {
        try{
            Collection<RecepcionProductos> re =recepcionProductosRepository.getAllRecepcionProductos();
            return ResponseEntity.ok(re);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/RecepcionProductos/new/save")
    public ResponseEntity<String> RecepcionProductosGuardar(@RequestBody RecepcionProductos recepcionProductos) {
        try {
            recepcionProductosRepository.insertRecepcionProductos(recepcionProductos.getFechaRecepcion(), recepcionProductos.getId_Bodega().getId(),
                                                        recepcionProductos.getId_OrdenCompra().getId());
        
        return new ResponseEntity<>("RecepcionProductos creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el RecepcionProductos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
