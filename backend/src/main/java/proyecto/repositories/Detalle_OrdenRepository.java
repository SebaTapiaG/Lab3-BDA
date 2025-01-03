package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import proyecto.entities.Detalle_OrdenEntity;

import java.util.List;

public interface Detalle_OrdenRepository extends MongoRepository<Detalle_OrdenEntity, String> {

    List<Detalle_OrdenEntity> findByIdOrden(String id_orden);  // Encuentra detalles por ID de orden
}
