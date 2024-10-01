package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.DetalleCostoBodega;
import uniandes.edu.co.proyecto.Repositories.DetalleCostoBodegaRepository;

@RestController
public class DetalleCostoBodegaController {
    
    @Autowired
    private DetalleCostoBodegaRepository detalleCostoBodegaRepository;

    @GetMapping("/DetalleCostoBodega")
    public ResponseEntity<Collection<DetalleCostoBodega>> getAllDetalleCostoBodega() {
        try {
            Collection<DetalleCostoBodega> detalles = detalleCostoBodegaRepository.getAllDetalleCostoBodega();
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/DetalleCostoBodega/new/save")
    public ResponseEntity<String> DetalleCostoBodegaGuardar(@RequestBody DetalleCostoBodega detalleCostoBodega) {
        try {
            detalleCostoBodegaRepository.insertDetalleCostoBodega(detalleCostoBodega.getCostoUnitarioBodega(), detalleCostoBodega.getCantidadExistencias());
        
        return new ResponseEntity<>("DetalleCostoBodega creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el DetalleCostoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
