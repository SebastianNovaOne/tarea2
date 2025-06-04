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

    @Test
    public void testCalcularTiempoReal() throws InterruptedException {
        reunion.iniciar();
        Thread.sleep(100);
        reunion.finalizar();
        float duracion = reunion.calcularTiempoReal();
        assertTrue(duracion >= 0);
    }

    @Test
    public void testObtenerAsistencias() {
        Empleado e1 = new Empleado("EMPLOYEE999", "Gomez", "Ximena", "ximena@gmail.com", null);
        Invitacion inv1 = new Invitacion(e1, Instant.now());
        inv1.marcarPresente();
        reunion.listaInvitados.add(inv1);

        Empleado e2 = new Empleado("EMPLOYEE777", "Yañez", "Pato", "pato@outlook.com", null);
        Invitacion inv2 = new Invitacion(e2, Instant.now());
        inv2.setEstado(EstadoAsistencia.AUSENTE);
        reunion.listaInvitados.add(inv2);

        List<Invitacion> presentes = reunion.obtenerAsistencias();
        assertEquals(1, presentes.size());
        assertEquals(EstadoAsistencia.PRESENTE, presentes.get(0).getEstado());
    }

    @Test
    public void testObtenerAusencias() {
        Empleado e1 = new Empleado("EMPLOYEE999", "Gomez", "Ximena", "ximena@gmail.com", null);
        Invitacion inv1 = new Invitacion(e1, Instant.now());
        inv1.setEstado(EstadoAsistencia.AUSENTE);
        reunion.listaInvitados.add(inv1);

        Empleado e2 = new Empleado("EMPLOYEE777", "Yañez", "Pato", "pato@outlook.com", null);
        Invitacion inv2 = new Invitacion(e2, Instant.now());
        inv2.marcarPresente();
        reunion.listaInvitados.add(inv2);

        List<Invitacion> ausentes = reunion.obtenerAusencias();
        assertEquals(1, ausentes.size());
        assertEquals(EstadoAsistencia.AUSENTE, ausentes.get(0).getEstado());
    }

    @Test
    public void testObtenerRetrasos() {
        Empleado e1 = new Empleado("EMPLOYEE999", "Gomez", "Ximena", "ximena@gmail.com", null);
        Invitacion inv1 = new Invitacion(e1, Instant.now());
        inv1.marcarRetraso(Instant.now());
        reunion.listaInvitados.add(inv1);

        Empleado e2 = new Empleado("EMPLOYEE777", "Yañez", "Pato", "pato@outlook.com", null);
        Invitacion inv2 = new Invitacion(e2, Instant.now());
        inv2.marcarPresente();
        reunion.listaInvitados.add(inv2);

        List<Invitacion> retrasados = reunion.obtenerRetrasos();
        assertEquals(1, retrasados.size());
        assertEquals(EstadoAsistencia.RETRASADO, retrasados.get(0).getEstado());
    }

    @Test
    public void testObtenerTotalAsistencia() {
        Invitacion inv1 = new Invitacion(new Empleado("EMPLOYEE999", "Gomez", "Ximena", "ximena@gmail.com", null), Instant.now());
        inv1.marcarPresente();
        reunion.listaInvitados.add(inv1);

        Invitacion inv2 = new Invitacion(new Empleado("EMPLOYEE777", "Yañez", "Pato", "pato@outlook.com", null), Instant.now());
        inv2.marcarRetraso(Instant.now());
        reunion.listaInvitados.add(inv2);

        Invitacion inv3 = new Invitacion(new Empleado("EMPLOYEE456", "Ruiz", "Laura", "laura@outlook.com", null), Instant.now());
        inv3.setEstado(EstadoAsistencia.AUSENTE);
        reunion.listaInvitados.add(inv3);

        assertEquals(2, reunion.obtenerTotalAsistencia());
    }

    @Test
    public void testObtenerPorcentajeAsistencia() {
        reunion.listaInvitados.clear();
        assertEquals(0, reunion.obtenerPorcentajeAsistencia(), 0.001);

        Invitacion inv1 = new Invitacion(new Empleado("EMPLOYEE999", "Gomez", "Ximena", "ximena@gmail.com", null), Instant.now());
        inv1.marcarPresente();
        reunion.listaInvitados.add(inv1);

        Invitacion inv2 = new Invitacion(new Empleado("EMPLOYEE777", "Yañez", "Pato", "pato@outlook.com", null), Instant.now());
        inv2.setEstado(EstadoAsistencia.AUSENTE);
        reunion.listaInvitados.add(inv2);

        assertEquals(50.0, reunion.obtenerPorcentajeAsistencia(), 0.001);
    }
}