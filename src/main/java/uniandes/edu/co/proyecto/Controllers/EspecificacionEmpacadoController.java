package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.EspecificacionEmpacado;
import uniandes.edu.co.proyecto.Repositories.EspecificacionEmpacadoRepository;

@RestController
public class EspecificacionEmpacadoController {
    
    @Autowired
    private EspecificacionEmpacadoRepository especificacionEmpacadoRepository;

    @GetMapping("/EspecificacionEmpacado")
    public Collection<EspecificacionEmpacado> getAllEspecificacionEmpacado() {
        return especificacionEmpacadoRepository.getAllEspecificacionEmpacado();
    }

    @PostMapping("/EspecificacionEmpacado/new/save")
    public ResponseEntity<String> EspecificacionEmpacadoGuardar(@RequestBody EspecificacionEmpacado especificacionEmpacado) {
        try {
            especificacionEmpacadoRepository.insertEspecificacionEmpacado(especificacionEmpacado.getVolumen_CM3(), especificacionEmpacado.getPeso_Gr());
        
        return new ResponseEntity<>("EspecificacionEmpacado creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el EspecificacionEmpacado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
