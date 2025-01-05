package proyecto.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.http.ResponseEntity;
//import proyecto.dto.ProductoMasCompradoDTO;
import proyecto.models.ProductoModel;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<ProductoModel, ObjectId> {

    ProductoModel findByNombre(String nombre);

    List<ProductoModel> findByCategoria(ObjectId id_categoria);

    // No es necesario tener create y update aquí, puedes usar los métodos de MongoRepository directamente
    // MongoRepository ya tiene save() para crear o actualizar

    void deleteById(ObjectId id_producto);  // MongoRepository ya maneja el delete por ID

    //List<ProductoMasCompradoDTO> productosMasCompradosPorClientes();

}
