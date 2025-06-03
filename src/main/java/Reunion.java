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

    public List<Invitacion> obtenerAsistencias() {
        List<Invitacion> presentes = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.PRESENTE) {
                presentes.add(i);
            }
        }
        return presentes;
    }

    public List<Invitacion> obtenerAusencias() {
        List<Invitacion> ausentes = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.AUSENTE) {
                ausentes.add(i);
            }
        }
        return ausentes;
    }

    public List<Invitacion> obtenerRetrasos() {
        List<Invitacion> retrasados = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.RETRASADO) {
                retrasados.add(i);
            }
        }
        return retrasados;
    }

    public int obtenerTotalAsistencia() {
        int total = 0;
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() != EstadoAsistencia.AUSENTE) {
                total++;
            }
        }
        return total;
    }

    public float obtenerPorcentajeAsistencia() {
        if (listaInvitados.isEmpty()) return 0;
        return 100f * obtenerTotalAsistencia() / listaInvitados.size();
    }
}