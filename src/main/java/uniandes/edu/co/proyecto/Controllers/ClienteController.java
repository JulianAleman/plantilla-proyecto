package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.Repositories.ClienteRepository;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/Clientes")
    public ResponseEntity<Collection<Cliente>> getAllClientes() {
        try{
            Collection<Cliente> clientes= clienteRepository.getClientes();
            return ResponseEntity.ok(clientes);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/Clientes/new/save")
    public ResponseEntity<String> BodegaGuardar(@RequestBody Cliente cliente) {
        try {
            clienteRepository.insertCliente(cliente.getCedula(), cliente.getNombre());
        
        return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear el Cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
