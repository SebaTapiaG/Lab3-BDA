package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.models.ProductoModel;
import proyecto.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public ResponseEntity<List<ProductoModel>> findAll() {
        List<ProductoModel> productos = productoRepository.findAll();
        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
    }

    // Obtener producto por ID
    public ResponseEntity<ProductoModel> findById(String id_producto) {
        Optional<ProductoModel> producto = Optional.of(productoRepository.findById(id_producto));
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());  // 404 si no lo encuentra
    }

    // Obtener producto por nombre
    public ResponseEntity<ProductoModel> findByNombre(String nombre) {
        ProductoModel producto = productoRepository.findByNombre(nombre);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.status(404).build();  // 404 si no lo encuentra
    }

    // Obtener productos por categoría
    public ResponseEntity<List<ProductoModel>> findByCategoria(int id_categoria) {
        List<ProductoModel> productos = productoRepository.findByCategoria(id_categoria);
        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
    }

    // Crear o actualizar producto
    public ResponseEntity<ProductoModel> create(ProductoModel producto) {
        ProductoModel savedProducto = productoRepository.save(producto);
        return ResponseEntity.ok(savedProducto);  // Retorna el producto guardado
    }

    // Actualizar producto
    public ResponseEntity<ProductoModel> update(ProductoModel producto) {
        if (productoRepository.existsById(producto.getId())) {
            ProductoModel updatedProducto = productoRepository.save(producto);
            return ResponseEntity.ok(updatedProducto);  // Retorna el producto actualizado
        }
        return ResponseEntity.status(404).build();  // 404 si no lo encuentra
    }

    // Eliminar producto por ID
    public ResponseEntity<String> delete(String id_producto) {
        if (productoRepository.existsById(id_producto)) {
            productoRepository.deleteById(id_producto);
            return ResponseEntity.ok("Producto eliminado con éxito");
        }
        return ResponseEntity.status(404).body("Producto no encontrado");
    }
}
