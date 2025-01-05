package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.service.CategoriaService;
import proyecto.models.CategoriaModel;

import java.util.List;
import java.util.Optional;

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
    public Optional<CategoriaModel> findById(@PathVariable ObjectId id_categoria) {
        return categoriaService.findById(id_categoria);
    }

    @GetMapping("/create")
    public CategoriaModel create(@RequestBody CategoriaModel categoria) {
        return categoriaService.create(categoria);
    }

    @DeleteMapping("/{id_categoria}")
    public void delete(@PathVariable ObjectId id_categoria) {
        categoriaService.delete(id_categoria);
    }



}
