package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.Repositories.CiudadRepository;

@RestController
public class CiudadController {
    
    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/Ciudades")
    public Collection<Ciudad> getAllCiudades() {
        return ciudadRepository.getCiudades();
    }

    @PostMapping("/Ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.insertCiudad(ciudad.getNombre());
        
        return new ResponseEntity<>("ciudad creada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
