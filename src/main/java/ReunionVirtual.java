import java.util.Date;
import java.time.Instant;
import java.time.Duration;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }
}