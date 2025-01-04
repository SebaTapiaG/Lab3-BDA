package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cliente")  // Indica que esta clase será almacenada en la colección "clientes"
public class ClienteModel {

    /* Atributos
    Campo Tipo de dato Descripción
    id_cliente ObjectId (PK) Identificador único del cliente
    nombre String Nombre completo del cliente
    direccion String Dirección del cliente
    email String Correo electrónico del cliente
    telefono String Teléfono de contacto
    latitud Double Latitud del cliente
    longitud Double Longitud del cliente
     */

    @Id
    private ObjectId id;

    private String nombre;
    private String contrasena;
    private String direccion;
    private String comuna;
    private String email;
    private String telefono;

    // Agregamos latitud y longitud
    private double latitud;
    private double longitud;

    public ObjectId getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id_cliente='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
