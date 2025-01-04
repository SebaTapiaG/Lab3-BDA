package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import proyecto.dto.RepartidorDTO;
import proyecto.models.OrdenModel;

import java.util.List;

@Repository
public interface OrdenRepository extends MongoRepository<OrdenModel, String> {

    // Puedes agregar métodos personalizados si los necesitas
    List<OrdenModel> findByClienteId(String id_cliente);  // Encuentra órdenes por ID de cliente

   // List<RepartidorDTO> findDeliveryCompletedInArea(int id_zona);
}
