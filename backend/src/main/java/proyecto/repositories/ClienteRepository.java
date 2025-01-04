package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import proyecto.models.ClienteModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel, String> {

    // Buscar un cliente por nombre
    Optional<ClienteModel> findByName(String name);

    // Buscar un cliente por su correo electrónico
    Optional<ClienteModel> findByEmail(String email);

    // Buscar todos los clientes
    List<ClienteModel> findAll();

    // No es necesario implementar estos métodos en el repositorio, se pueden implementar en el servicio
    // Buscar cliente por ID
    Optional<ClienteModel> findById(String id_cliente);

    

    


}
