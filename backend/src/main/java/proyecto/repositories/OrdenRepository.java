package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import proyecto.dto.RepartidorDTO;
import proyecto.models.OrdenModel;

import java.util.List;

public interface OrdenRepository extends MongoRepository<OrdenModel, ObjectId> {

    // Puedes agregar métodos personalizados si los necesitas
    List<OrdenModel> findByIdCliente(ObjectId id_cliente);  // Encuentra órdenes por ID de cliente

   // List<RepartidorDTO> findDeliveryCompletedInArea(int id_zona);
}
