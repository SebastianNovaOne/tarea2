import java.time.Instant;

public class Nota {
    private String contenido;
    private Instant fechaCreacion;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.fechaCreacion = Instant.now();
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String toString() {
        return "[" + fechaCreacion + "]" + contenido;
    }
}
