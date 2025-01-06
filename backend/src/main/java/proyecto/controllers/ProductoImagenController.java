package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.models.ProductoImagenModel;
import proyecto.service.ProductoImagenService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/productoimagen")
public class ProductoImagenController {

    private final ProductoImagenService productoImagenService;

    public ProductoImagenController(ProductoImagenService productoImagenService) {
        this.productoImagenService = productoImagenService;
    }


    @GetMapping("/producto/{id_producto}")
    public ResponseEntity<List<ProductoImagenModel>> findById_producto(@PathVariable ObjectId id_producto){
        return productoImagenService.findByIdProducto(id_producto);
    }

}
