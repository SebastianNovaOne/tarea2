import java.util.Date;
import java.time.Instant;
import java.time.Duration;

/**
 * Representa una reunion virtual, que extiende la clase {@link Reunion}.
 * Esta clase agrega un enlace, necesario para unirse a la reunion.
 *
 * @see Reunion
 */
public class ReunionVirtual extends Reunion {

    /**
     * El enlace para unirse a la reunión virtual.
     */
    private String enlace;

    /**
     * Constructor que crea una nueva reunion virtual con los datos proporcionados.
     *
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de inicio de la reunion.
     * @param duracionPrevista Duración prevista de la reunion.
     * @param organizador Empleado que organiza la reunion.
     * @param tipo Tipo de la reunion (por ejemplo, tecnica, marketing).
     * @param enlace Enlace para unirse a la reunion virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }

    /**
     * Devuelve enlace de la reunion virtual.
     *
     * @return Enlace de la reunion.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Establece enlace de la reunion virtual.
     *
     * @param enlace Nuevo enlace de la reunion (solo si aplica).
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

}