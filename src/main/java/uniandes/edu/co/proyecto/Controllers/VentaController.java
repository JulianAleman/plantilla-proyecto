package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Venta;
import uniandes.edu.co.proyecto.Repositories.VentaRepository;

@RestController
public class VentaController {
    
    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/Ventas")
    public Collection<Venta> getAllVentas() {
        return ventaRepository.getAllVentas();
    }

    @PostMapping("/Ventas/new/save")
    public ResponseEntity<String> VentasGuardar(@RequestBody Venta venta) {
        try {
            ventaRepository.insertVenta(venta.getFecha(), venta.getId_Sucursal().getId(), venta.getId_Cliente().getCedula());
        
        return new ResponseEntity<>("venta creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
