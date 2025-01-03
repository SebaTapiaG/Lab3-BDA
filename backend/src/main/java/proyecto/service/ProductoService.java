package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.entities.ProductoEntity;
import proyecto.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public ResponseEntity<List<ProductoEntity>> findAll() {
        List<ProductoEntity> productos = productoRepository.findAll();
        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
    }

    // Obtener producto por ID
    public ResponseEntity<ProductoEntity> findById(String id_producto) {
        Optional<ProductoEntity> producto = Optional.of(productoRepository.findById(id_producto));
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());  // 404 si no lo encuentra
    }

    // Obtener producto por nombre
    public ResponseEntity<ProductoEntity> findByNombre(String nombre) {
        ProductoEntity producto = productoRepository.findByNombre(nombre);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.status(404).build();  // 404 si no lo encuentra
    }

    // Obtener productos por categoría
    public ResponseEntity<List<ProductoEntity>> findByCategoria(int id_categoria) {
        List<ProductoEntity> productos = productoRepository.findByCategoria(id_categoria);
        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
    }

    // Crear o actualizar producto
    public ResponseEntity<ProductoEntity> create(ProductoEntity producto) {
        ProductoEntity savedProducto = productoRepository.save(producto);
        return ResponseEntity.ok(savedProducto);  // Retorna el producto guardado
    }

    // Actualizar producto
    public ResponseEntity<ProductoEntity> update(ProductoEntity producto) {
        if (productoRepository.existsById(producto.getId())) {
            ProductoEntity updatedProducto = productoRepository.save(producto);
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
