package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.Repositories.ProveedorRepository;

@RestController
public class ProveedorController {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/Proveedores")
    public ResponseEntity<Collection<Proveedor>>getAllProveedores() {
        try{
            Collection<Proveedor> pro=proveedorRepository.getAllProveedores();
            return ResponseEntity.ok(pro);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/Proveedores/new/save")
    public ResponseEntity<String> ProveedoresGuardar(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.insertProveedor(proveedor.getNIT(), proveedor.getNombre(),
                                        proveedor.getDireccion(), proveedor.getNombreContacto(),
                                        proveedor.getTelefonoContacto());
        
        return new ResponseEntity<>("proveedor creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/Proveedores/Update")
    public ResponseEntity<String> ActualizarEstado(@RequestParam Long nit, @RequestParam String contacto)  {
        try {
            proveedorRepository.updateProveedor(nit, contacto);
        return new ResponseEntity<>("OrdenCompra Actualizada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al actualizar la OrdenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}
