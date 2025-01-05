package proyecto.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Repartidor")
public class RepartidorModel {

    /* Atributos
    Campo Tipo de dato Descripción
    id_repartidor SERIAL (PK) Identificador único del repartidor
    nombre VARCHAR(255) Nombre completo del repartidor
    direccion VARCHAR(255) Dirección del repartidor
    email VARCHAR(100) Correo electrónico del repartidor
    telefono VARCHAR(20) Teléfono de contacto
     */

    @Id
    private ObjectId id;
    private String nombre;

    private String contrasena;
    private String email;
    private String telefono;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
