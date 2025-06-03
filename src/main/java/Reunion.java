import java.time.*;
import java.util.*;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Empleado organizador;
    private TipoReunion tipo;
    List<Invitacion> listaInvitados = new ArrayList<>();
    List<Nota> notas = new ArrayList<>();

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
    }

    public void iniciar() {
        horaInicio = Instant.now();
    }

    public void finalizar() {
        horaFin = Instant.now();
    }

    public float calcularTiempoReal() {
        return Duration.between(horaInicio, horaFin).toMinutes();
    }
}