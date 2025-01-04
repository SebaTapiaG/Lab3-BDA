package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Zona")
public class ZonaModel {
    @Id
    private ObjectId id; // Clave primaria
    private String nombre; // Nombre de la zona
    private String estado; // Estado de la zona (activo, inactivo, etc.)
    private String area; // Representación WKT (Well-Known Text) del POLYGON


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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    // Método toString para imprimir el objeto de forma legible
    @Override
    public String toString() {
        return "ZonaEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}

