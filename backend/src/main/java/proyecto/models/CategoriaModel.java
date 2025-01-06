package proyecto.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class CategoriaModel {
    /* Atributos
    Campo Tipo de dato Descripción
    id_categoria SERIAL (PK) Identificador único de la categoría
    nombre VARCHAR(100) Nombre de la categoría
     */

    @Id
    private ObjectId id;
    private String nombre;


    public ObjectId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
