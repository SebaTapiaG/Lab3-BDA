package proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import proyecto.entities.ClienteEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

    // Buscar un cliente por nombre
    Optional<ClienteEntity> findByName(String name);

    // Buscar un cliente por su correo electrónico
    Optional<ClienteEntity> findByEmail(String email);

    // Buscar todos los clientes
    List<ClienteEntity> findAll();

    // No es necesario implementar estos métodos en el repositorio, se pueden implementar en el servicio
    // Buscar cliente por ID
    Optional<ClienteEntity> findById(String id_cliente);


}
