package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.Repositories.CategoriaRepository;

@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/Categorias")
    public ResponseEntity<Collection<Categoria>> getAllCategorias() {
        try{
        Collection<Categoria> categorias= categoriaRepository.getCategorias();
         return ResponseEntity.ok(categorias);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/Categorias/codigo")
    public ResponseEntity<Categoria> getCategoriaByCodigo(@RequestParam Long codigo) {
    try {
        Categoria categoria = categoriaRepository.getCategoria(codigo);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @PostMapping("/Categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.insertCategoria(categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicasAlmacenamiento());
        
        return new ResponseEntity<>("categoria creada exitosamente", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
