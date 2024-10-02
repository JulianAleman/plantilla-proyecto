package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Repositories.BodegaRepository;
import uniandes.edu.co.proyecto.Repositories.BodegaRepository.respuestaocupaciondeunabodega;
import uniandes.edu.co.proyecto.modelo.Bodega;


@RestController
public class BodegaController {
    
    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/Bodegas")
    public ResponseEntity<Collection<Bodega>> getAllBodegas() {
        try{
            Collection<Bodega> bodegas = bodegaRepository.getBodegas();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/Bodega/Consulta")
    public ResponseEntity<?> bodegasConsulta(@RequestParam(required = false) String sucursal, @RequestParam(required = false) List<Long> codigos) {
        try {
            Collection<respuestaocupaciondeunabodega> informacion = bodegaRepository.mostrarocupaciondeunabodega();
            Map<String, Object> response = new HashMap<>();
            response.put("Porcentaje_Ocupacion_Todas", informacion);
            Collection<Bodega> bodegas;

            if (sucursal == null || sucursal.isEmpty() || codigos.isEmpty()) {
                bodegas = bodegaRepository.getBodegas();

            } else {
                bodegas = bodegaRepository.Bodegas(Long.parseLong(sucursal), codigos);
            }
            response.put("Bodegas", bodegas);
            
            return ResponseEntity.ok(response);
    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al consultar las bodegas: " + e.getMessage());
        }
    }

     
    @PostMapping("/Bodegas/new/save")
    public ResponseEntity<String> BodegaGuardar(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.insertBodega(bodega.getNombre(), bodega.getTamanio(), bodega.getSucursal().getId());
        
        return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<?> bebidaBorrar(@PathVariable("id") long id) {
        try {
            bodegaRepository.deleteBodega(id);
            return ResponseEntity.ok("Bebida eliminada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bebida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
