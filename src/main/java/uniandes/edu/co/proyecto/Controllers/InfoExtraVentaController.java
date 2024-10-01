package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraVenta;
import uniandes.edu.co.proyecto.Repositories.InfoExtraVentaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class InfoExtraVentaController {
    
    @Autowired
    private InfoExtraVentaRepository infoExtraVentaRepository;

    @GetMapping("/InfoExtraVentas")
    public ResponseEntity<Collection<InfoExtraVenta>> getAllInfoExtraVenta() {
        try{
            Collection<InfoExtraVenta>info=infoExtraVentaRepository.getAllInfoExtraVenta();
            return ResponseEntity.ok(info);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/InfoExtraVentas/new/save")
    public ResponseEntity<String> infoExtraVentaGuardar(@RequestBody InfoExtraVenta infoExtraVentas) {
        try {
        infoExtraVentaRepository.insertInfoExtraVenta(infoExtraVentas.getPk().getCodigoBarras().getCodigoBarras(), infoExtraVentas.getPk().getId_venta().getId(),
                                            infoExtraVentas.getPk().getCantidad(), infoExtraVentas.getPk().getPrecioUnitarioVenta());
        
        return new ResponseEntity<>("InfoExtraVenta creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el InfoExtraVenta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
