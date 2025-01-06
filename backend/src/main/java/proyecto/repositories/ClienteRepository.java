package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import proyecto.models.ClienteModel;
import proyecto.models.TarjetaModel;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends MongoRepository<ClienteModel, ObjectId> {

    // Buscar un cliente por nombre
    Optional<ClienteModel> findByNombre(String name);

    // Buscar un cliente por su correo electrónico
    Optional<ClienteModel> findByEmail(String email);


}
