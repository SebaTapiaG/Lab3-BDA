package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.models.ProductoModel;
import proyecto.service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/producto")

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }



    @GetMapping("")
    public ResponseEntity<List<ProductoModel>> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/{producto}")
    public ResponseEntity<ProductoModel> findById(@PathVariable String producto) {
        return productoService.findByNombre(producto);

    }

    /*

    @PostMapping("/create")
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel producto){
        return productoService.create(producto);
    }

    /*
    @GetMapping("/top")
    public ResponseEntity<List<ProductoMasCompradoDTO>> getProductosMasComprados() {
        return productoService.getProductosMasComprados();
    }

    @PutMapping("/update")
    public ResponseEntity<ProductoModel> update(@RequestBody ProductoModel producto){
        return productoService.update(producto);
    }

    @DeleteMapping("/delete/{id_producto}")
    public ResponseEntity<String> delete(@PathVariable ObjectId id_producto){
        return productoService.delete(id_producto);
    }
    */

}
