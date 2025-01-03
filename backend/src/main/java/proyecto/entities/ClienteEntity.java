package proyecto.entities;

public class ClienteEntity {

    /* Atributos
    Campo Tipo de dato Descripción
    id_cliente SERIAL (PK) Identificador único del cliente
    nombre VARCHAR(255) Nombre completo del cliente
    direccion VARCHAR(255) Dirección del cliente
    email VARCHAR(100) Correo electrónico del cliente
    telefono VARCHAR(20) Teléfono de contacto
     */

    private int id_cliente;
    private String nombre;

    private String contrasena;
    private String direccion;
    private String comuna;
    private String email;
    private String telefono;

    //Agregamos latitud y longitud
    private double latitud;
    private double longitud;

    public ClienteEntity(int id_cliente, String nombre, String contrasena,
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

    public ClienteEntity() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return this.comuna;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
                "id_cliente=" + id_cliente +
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
