import java.time.Instant;

public class Nota {
    private String contenido;
    private Instant fechaCreacion;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.fechaCreacion = Instant.now();
    }
}
