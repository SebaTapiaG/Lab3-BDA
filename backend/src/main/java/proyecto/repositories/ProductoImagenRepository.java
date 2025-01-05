package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import proyecto.models.ProductoImagenModel;

import java.util.List;

public interface ProductoImagenRepository extends MongoRepository<ProductoImagenModel, ObjectId> {

    // Método para encontrar las imágenes por el id_producto
    List<ProductoImagenModel> findById_producto(String id_producto);

    // Método para encontrar una imagen por su tipo (por ejemplo, "imagen", "video")
    List<ProductoImagenModel> findByTipo(String tipo);

    // Método para encontrar una imagen por su nombre de archivo
    List<ProductoImagenModel> findByNombreArchivo(String nombreArchivo);

    // Método para encontrar una imagen por su descripción
    List<ProductoImagenModel> findByDescripcion(String descripcion);
}
