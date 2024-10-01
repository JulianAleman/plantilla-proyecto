package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraProveedor;
import uniandes.edu.co.proyecto.Repositories.InfoExtraProveedorRepository;

@RestController
public class InfoExtraProveedorController {
    
    @Autowired
    private InfoExtraProveedorRepository infoExtraProveedorRepository;

    @GetMapping("/InfoExtraProveedor")
    public Collection<InfoExtraProveedor> getAllInfoExtraProveedor() {
        return infoExtraProveedorRepository.getAllInfoExtraProveedors();
    }

    @PostMapping("/InfoExtraProveedor/new/save")
    public ResponseEntity<String> infoExtraProveedorGuardar(@RequestBody InfoExtraProveedor infoExtraProveedor) {
        try {
        infoExtraProveedorRepository.insertInfoExtraProveedor(infoExtraProveedor.getPk().getNit().getNIT(), infoExtraProveedor.getPk().getCodBar().getCodigoBarras());
        
        return new ResponseEntity<>("InfoExtraProveedor creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el InfoExtraProveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
