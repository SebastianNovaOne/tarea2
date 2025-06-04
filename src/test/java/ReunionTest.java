import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.*;
import java.util.*;

public class ReunionTest {

    private Reunion reunion;
    private Empleado organizador;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;

    @BeforeEach
    public void setup() {
        organizador = new Empleado("EMPLOYEE999", "Perez", "Juan", "juan.perez@correo.com", null);
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofMinutes(60);
        reunion = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, organizador, TipoReunion.TECNICA, "Sala 1000");
    }

    @Test
    public void testIniciarYFinalizar() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());
        assertTrue(reunion.getHoraFin().isAfter(reunion.getHoraInicio()) || reunion.getHoraFin().equals(reunion.getHoraInicio()));
    }
}