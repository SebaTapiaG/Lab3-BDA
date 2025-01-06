package proyecto.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class TarjetaModel {

    @Id // Identificador único en MongoDB
    private ObjectId id;
    private String numero;
    private String fechaVencimiento;
    private String cvv;
    private Boolean esCredito;

    // Constructor
    public TarjetaModel(String numero, String fechaVencimiento, String cvv, Boolean esCredito) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.esCredito = esCredito;
    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Boolean getEsCredito() {
        return esCredito;
    }

    public void setEsCredito(Boolean esCredito) {
        this.esCredito = esCredito;
    }
}
