package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.Repositories.SucursalRepository;
import uniandes.edu.co.proyecto.Repositories.SucursalRepository.SucursalInfo;

@RestController
public class SucursalController {
    
    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/Sucursales")
    public ResponseEntity<Collection<Sucursal>> getAllSucursales() {
        try{
            Collection<Sucursal> s= sucursalRepository.getAllSucursales();
            return ResponseEntity.ok(s);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

     @GetMapping("/Sucursales/Productos")
    public ResponseEntity<?> getProductosEspecificaciones(@RequestParam(required = false) Long producto) {
        
        try{
            Map<String, Object> response = new HashMap<>();
            Collection<SucursalInfo> productos;
            if (producto != null) {
                productos = sucursalRepository.SucursalesDeProducto(producto);}

            else{
                productos =sucursalRepository.SucursalesDeProducto1();;
            }
            response.put("Sucursales", productos);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
}
