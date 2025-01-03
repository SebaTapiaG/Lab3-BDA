package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import proyecto.entities.ProductoImagenEntity;

import java.util.List;

public interface ProductoImagenRepository extends MongoRepository<ProductoImagenEntity, String> {

    // Método para encontrar las imágenes por el id_producto
    List<ProductoImagenEntity> findById_producto(String id_producto);

    // Método para encontrar una imagen por su tipo (por ejemplo, "imagen", "video")
    List<ProductoImagenEntity> findByTipo(String tipo);

    // Método para encontrar una imagen por su nombre de archivo
    List<ProductoImagenEntity> findByNombreArchivo(String nombreArchivo);

    // Método para encontrar una imagen por su descripción
    List<ProductoImagenEntity> findByDescripcion(String descripcion);
}
