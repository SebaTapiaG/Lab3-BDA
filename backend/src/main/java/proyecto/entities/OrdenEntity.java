package proyecto.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "ordenes") // Indica que esta clase representa una colección en MongoDB
public class OrdenEntity {

    @Id // Identificador único en MongoDB
    private String id; // MongoDB utiliza un identificador de tipo String por defecto
    private Instant fechaOrden; // Usamos Instant para fechas en lugar de Timestamp
    private String estado; // Puede ser "pendiente", "pagada", "enviada", etc.
    private String idCliente; // Relación con el cliente (referencia)
    private double total; // Total a pagar
    private double latitud; // Coordenada geográfica
    private double longitud; // Coordenada geográfica
    private String idRepartidor; // Relación con el repartidor (referencia)

    // Constructor
    public OrdenEntity(Instant fechaOrden, String estado, String idCliente,
                       double total, double latitud, double longitud, String idRepartidor) {
        this.fechaOrden = fechaOrden;
        this.estado = estado;
        this.idCliente = idCliente;
        this.total = total;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idRepartidor = idRepartidor;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Instant fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
}
