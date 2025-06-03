import java.time.Instant;

/**
 * Representa una nota asociada a una reunion.
 * Contiene el contenido de la nota y la fecha en que se hizo.
 */
public class Nota {
    private String contenido;
    private Instant fechaCreacion;

    /**
     * Crea una nota con contenido proporcionado.
     * La fecha de creacion se establece al momento actual.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
        this.fechaCreacion = Instant.now();
    }

    /**
     * Devuelve el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece un nuevo contenido para la nota.
     *
     * @param contenido El nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve la fecha de creacion de la nota.
     *
     * @return La fecha de creacion como un Instant.
     */
    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece una nueva fecha de creacion para la nota.
     *
     * @param fechaCreacion La nueva fecha de creacion.
     */
    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Devuelve una representacion en texto de la nota,
     * incluyendo la fecha de creacion y el contenido.
     *
     * @return Una String que representa la nota.
     */
    public String toString() {
        return "[" + fechaCreacion + "]" + contenido;
    }
}