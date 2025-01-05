package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import proyecto.models.CategoriaModel;

public interface CategoriaRepository extends MongoRepository<CategoriaModel, ObjectId> {
}
