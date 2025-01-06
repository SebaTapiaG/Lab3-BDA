package proyecto.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.models.ProductoImagenModel;
import proyecto.repositories.ProductoImagenRepository;

import java.util.List;

@Service
public class ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    // Obtener todas las imágenes de un producto específico
    public ResponseEntity<List<ProductoImagenModel>> findByIdProducto(ObjectId idProducto) {
        List<ProductoImagenModel> productoImagenes = productoImagenRepository.findByIdProducto(idProducto);
        return productoImagenes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productoImagenes);
    }

    // Obtener todas las imágenes por su tipo (imagen o video)
    public ResponseEntity<List<ProductoImagenModel>> findByTipo(String tipo) {
        List<ProductoImagenModel> productoImagenes = productoImagenRepository.findByTipo(tipo);
        return productoImagenes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productoImagenes);
    }

    // Obtener imágenes por nombre de archivo
    public ResponseEntity<List<ProductoImagenModel>> findByNombreArchivo(String nombreArchivo) {
        List<ProductoImagenModel> productoImagenes = productoImagenRepository.findByNombreArchivo(nombreArchivo);
        return productoImagenes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productoImagenes);
    }

    // Obtener imágenes por descripción
    public ResponseEntity<List<ProductoImagenModel>> findByDescripcion(String descripcion) {
        List<ProductoImagenModel> productoImagenes = productoImagenRepository.findByDescripcion(descripcion);
        return productoImagenes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productoImagenes);
    }
}
