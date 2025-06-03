import java.util.Date;
import java.time.Instant;
import java.time.Duration;

/**
 * Representa una reunion presencial, que extiende la clase {@link Reunion}.
 * Esta clase agrega el una sala, necesaria para realizar la reunion presencial.
 *
 * @see Reunion
 */
public class ReunionPresencial extends Reunion {

    /**
     * Sala donde se lleva a cabo la reunion presencial.
     */
    private String sala;

    /**
     * Constructor que crea una reunion presencial con los datos proporcionados.
     *
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de inicio de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param organizador Empleado que organiza la reunion.
     * @param tipo Tipo de la reunion (por ejemplo, tecnica, marketing).
     * @param sala Sala donde se realizara la reunion presencial.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String sala) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.sala = sala;
    }

    /**
     * Devuelve la sala de la reunion presencial.
     *
     * @return La sala de la reunion.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Establece la sala de la reunion presencial.
     *
     * @param sala La nueva sala de la reunion (solamente si aplica).
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

}