package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Orden") // Indica que esta clase representa una colección en MongoDB
public class OrdenModel {

    @Id // Identificador único en MongoDB
    private ObjectId id; // MongoDB utiliza un identificador de tipo String por defecto
    private Instant fechaOrden; // Usamos Instant para fechas en lugar de Timestamp
    private String estado; // Puede ser "pendiente", "pagada", "enviada", etc.
    private String emailCliente; // Relación con el cliente (referencia)
    private double total; // Total a pagar
    private double latitud; // Coordenada geográfica
    private double longitud; // Coordenada geográfica
    private List<DetalleModel> detalles; // Lista de productos en la orden


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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

    public List<DetalleModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleModel> detalles) {
        this.detalles = detalles;
    }
}
