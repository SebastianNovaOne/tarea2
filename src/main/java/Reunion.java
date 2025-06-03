import java.io.FileWriter;
import java.io.IOException;
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

    public String generarInforme() {
        StringBuilder sb = new StringBuilder();
        sb.append("INFORME DE REUNION\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Inicio: ").append(horaInicio).append(" - Fin: ").append(horaFin).append("\n");
        sb.append("Duracion real (min): ").append(calcularTiempoReal()).append("\n");
        sb.append("Tipo: ").append(tipo).append("\n");

        if (this instanceof ReunionVirtual) {
            ReunionVirtual rv = (ReunionVirtual) this;
            sb.append("Enlace: ").append(rv.getEnlace()).append("\n");
        } else if (this instanceof ReunionPresencial) {
            ReunionPresencial rp = (ReunionPresencial) this;
            sb.append("Sala: ").append(rp.getSala()).append("\n");
        }

        sb.append("Asistencia:\n");
        for (Invitacion i : listaInvitados) {
            sb.append("- ").append(i.toString()).append("\n");
        }

        sb.append("Notas:\n");
        for (Nota n : notas) {
            sb.append("- ").append(n.toString()).append("\n");
        }

        return sb.toString();
    }

    public void guardarInformeEnArchivo(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(generarInforme());
            System.out.println("Informe guardado en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el informe: " + e.getMessage());
        }
    }
}