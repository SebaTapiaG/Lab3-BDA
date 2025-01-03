package proyecto.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")  // Indica que esta clase será almacenada en la colección "clientes"
public class ClienteEntity {

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

    @Id  // Se usa para marcar el campo como la clave primaria (_id en MongoDB)
    private String id_cliente; // Usamos String para almacenar el ObjectId en MongoDB

    private String nombre;
    private String contrasena;
    private String direccion;
    private String comuna;
    private String email;
    private String telefono;

    // Agregamos latitud y longitud
    private double latitud;
    private double longitud;

    // Constructor
    public ClienteEntity(String id_cliente, String nombre, String contrasena,
                         String direccion, String comuna, String email,
                         String telefono, double latitud, double longitud) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.comuna = comuna;
        this.email = email;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Constructor vacío
    public ClienteEntity() {}

    // Getters y setters
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
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
                "id_cliente='" + id_cliente + '\'' +
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
