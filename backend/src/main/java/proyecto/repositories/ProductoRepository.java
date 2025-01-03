package proyecto.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.http.ResponseEntity;
//import proyecto.dto.ProductoMasCompradoDTO;
import proyecto.entities.ProductoEntity;

import java.util.List;

public interface ProductoRepository extends MongoRepository<ProductoEntity, String> {

    //List<ProductoEntity> findAll();  // MongoRepository ya tiene este método por defecto

    ProductoEntity findById(String id_producto);  // Cambiar a String si usas ID como String en Mongo

    ProductoEntity findByNombre(String nombre);

    List<ProductoEntity> findByCategoria(int id_categoria);

    // No es necesario tener create y update aquí, puedes usar los métodos de MongoRepository directamente
    // MongoRepository ya tiene save() para crear o actualizar

    void deleteById(String id_producto);  // MongoRepository ya maneja el delete por ID

    //List<ProductoMasCompradoDTO> productosMasCompradosPorClientes();
}
}
