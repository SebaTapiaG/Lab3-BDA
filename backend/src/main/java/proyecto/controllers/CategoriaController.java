package proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.service.CategoriaService;
import proyecto.models.CategoriaModel;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categoria")
public class CategoriaController {

   private final CategoriaService categoriaService;
   public CategoriaController(CategoriaService categoriaService) {
       this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Object>> findAll(){
        return (ResponseEntity<List<Object>>) categoriaService.findAll();
    }

    @GetMapping("/{id_categoria}")
    public ResponseEntity<Object> findById(@PathVariable int id_categoria) {
        return categoriaService.findById(id_categoria);
    }

    @GetMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CategoriaModel categoria) {
        return categoriaService.create(categoria);
    }

    @PutMapping("/")
    public ResponseEntity<Object> update(@RequestBody CategoriaModel categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id_categoria}")
    public ResponseEntity<Object> delete(@PathVariable int id_categoria) {
        return categoriaService.delete(id_categoria);
    }



}
