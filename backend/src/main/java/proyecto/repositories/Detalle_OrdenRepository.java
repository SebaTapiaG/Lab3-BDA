package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Detalle_OrdenRepository extends MongoRepository<Detalle_OrdenModel, String> {

    List<Detalle_OrdenModel> findByIdOrden(String id_orden);  // Encuentra detalles por ID de orden
}
