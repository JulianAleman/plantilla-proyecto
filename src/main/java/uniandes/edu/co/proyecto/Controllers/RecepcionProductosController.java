package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.RecepcionProductos;
import uniandes.edu.co.proyecto.servicios.RecepcionProductosServicio;
import uniandes.edu.co.proyecto.Repositories.RecepcionProductosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RecepcionProductosController {
    
    @Autowired
    private RecepcionProductosRepository recepcionProductosRepository;

    @Autowired
    private RecepcionProductosServicio recepcionProductosServicio;

    @GetMapping("/RecepcionProductos")
    public ResponseEntity<Collection<RecepcionProductos>> getAllRecepcionProductos() {
        try{
            Collection<RecepcionProductos> re =recepcionProductosRepository.todosRecepcionProductos();
            return ResponseEntity.ok(re);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
     
    @PostMapping("/RecepcionProductos/new/save")
    public ResponseEntity<String> RecepcionProductosGuardar(@RequestBody RecepcionProductos recepcionProductos) {
        try {
            recepcionProductosServicio.InsertarRecepcion(recepcionProductos);
        return new ResponseEntity<>("RecepcionProductos creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el RecepcionProductos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("RecepcionProductos/consultarD3")
    public  ResponseEntity<?> consultarDocumentosIngreso3(@RequestParam(required = false) Long idBodega, @RequestParam(required = false) Long idSucursal) {
        try{
            Map<String, Object> response = new HashMap<>();
            Collection<RecepcionProductos> documentos;
            if (idBodega!= null & idSucursal!=null) {
                documentos = recepcionProductosServicio.docPorId(idBodega, idSucursal);
            } else {
                documentos = recepcionProductosRepository.todosRecepcionProductos();
            }
            response.put("Documentos", documentos);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("RecepcionProductos/consultarD4")
    public  ResponseEntity<?> consultarDocumentosIngreso4(@RequestParam(required = false) Long idBodega, @RequestParam(required = false) Long idSucursal) {
        try{
            Map<String, Object> response = new HashMap<>();
            Collection<RecepcionProductos> documentos;
            if (idBodega!= null & idSucursal!=null) {
                documentos = recepcionProductosServicio.documentosPorIdespecifico(idBodega, idSucursal);
            } else {
                documentos = recepcionProductosRepository.todosRecepcionProductos();
            }
            response.put("Documentos", documentos);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    
}
