package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.Repositories.SucursalRepository;

@RestController
public class SucursalController {
    
    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/Sucursales")
    public Collection<Sucursal> getAllSucursales() {
        return sucursalRepository.getAllSucursales();
    }

    @PostMapping("/Sucursales/new/save")
    public ResponseEntity<String> SucursalGuardar(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertSucursal(sucursal.getNombre(), sucursal.getTamanio(), sucursal.getDireccion(),
                                        sucursal.getTelefono(), sucursal.getCodigo_Ciudad().getCodigo());
        
        return new ResponseEntity<>("Sucursal creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el Sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
