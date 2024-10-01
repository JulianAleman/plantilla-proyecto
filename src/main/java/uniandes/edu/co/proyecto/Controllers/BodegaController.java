package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.Repositories.BodegaRepository;
import uniandes.edu.co.proyecto.Repositories.BodegaRepository.respuestaocupaciondeunabodega;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BodegaController {
    
    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/Bodegas")
    public Collection<Bodega> getAllBodegas() {
        return bodegaRepository.getBodegas();
    }
    @GetMapping("/bodega/consula")
    public ResponseEntity<?> bodegasConsulta(@RequestParam(required = false) String sucursal,@RequestParam(required = false) List<Long> codigos) {
        try{
            Collection<respuestaocupaciondeunabodega>informacion = bodegaRepository.mostrarbodegas1();
            respuestaocupaciondeunabodega info = informacion.iterator().next();
            Map<String, Object> response = new HashMap<>();
            response.put("PromedioOcupacion", info.getPROMEDIO_OCUPACION());
            
            Collection<Bodega> bodegas;
            if (sucursal.isEmpty()|| sucursal==null|| codigos.isEmpty()){
                    bodegas = bodegaRepository.getBodegas();

            } else{
                    bodegas= bodegaRepository.mostrarocupaciondeunabodega(Long.parseLong(sucursal), codigos);
            }
            response.put("Bodegas", bodegas);

            return ResponseEntity.ok(response);
     
        }  catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }  
    }

     
    @PostMapping("/Bodegas/new/save")
    public ResponseEntity<String> BodegaGuardar(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.insertBodega(bodega.getNombre(), bodega.getTamanio(), bodega.getSucursal());
        
        return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
