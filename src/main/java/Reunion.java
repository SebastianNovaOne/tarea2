import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.util.*;

/**
 * Representa una reunion en una empresa u organizacion.
 * Esta clase es abstracta y contiene los detalles basicos de una reunion, como la fecha, hora prevista,
 * duracion, organizador, tipo de reunion, y los invitados.
 * Se pueden obtener informes sobre la asistencia, retrasos, ausencias y la duracion real de la reunion.
 */
public abstract class Reunion {

    /**
     * Fecha de la reunion.
     */
    private Date fecha;

    /**
     * Hora prevista de inicio de la reunion.
     */
    private Instant horaPrevista;

    /**
     * Duracion prevista de la reunion.
     */
    private Duration duracionPrevista;

    /**
     * Hora real de inicio de la reunion.
     */
    private Instant horaInicio;

    /**
     * Hora real de fin de la reunion.
     */
    private Instant horaFin;

    /**
     * Organizador de la reunion.
     */
    private Empleado organizador;

    /**
     * Tipo de reunion.
     */
    private TipoReunion tipo;

    /**
     * Lista de invitaciones para los asistentes a la reunion.
     */
    List<Invitacion> listaInvitados = new ArrayList<>();

    /**
     * Lista de notas asociadas a la reunion.
     */
    List<Nota> notas = new ArrayList<>();

    /**
     * Constructor que inicializa los parametros principales de la reunion.
     *
     * @param fecha La fecha de la reunion.
     * @param horaPrevista La hora prevista de la reunion.
     * @param duracionPrevista La duracion prevista de la reunion.
     * @param organizador El organizador de la reunion.
     * @param tipo El tipo de reunion.
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
    }

    /**
     * Inicia la reunion estableciendo la hora de inicio al momento actual.
     */
    public void iniciar() {
        horaInicio = Instant.now();
    }

    /**
     * Finaliza la reunion estableciendo la hora de fin al momento actual.
     */
    public void finalizar() {
        horaFin = Instant.now();
    }

    /**
     * Calcula el tiempo real que duro la reunion en minutos.
     *
     * @return La duracion real de la reunion en minutos.
     */
    public float calcularTiempoReal() {
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    /**
     * Obtiene la lista de invitaciones de los asistentes presentes a la reunion.
     *
     * @return Lista de invitaciones de los asistentes presentes.
     */
    public List<Invitacion> obtenerAsistencias() {
        List<Invitacion> presentes = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.PRESENTE) {
                presentes.add(i);
            }
        }
        return presentes;
    }

    /**
     * Obtiene la lista de invitaciones de los ausentes a la reunion.
     *
     * @return Lista de invitaciones de los ausentes.
     */
    public List<Invitacion> obtenerAusencias() {
        List<Invitacion> ausentes = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.AUSENTE) {
                ausentes.add(i);
            }
        }
        return ausentes;
    }

    /**
     * Obtiene la lista de invitaciones de los retrasados a la reunion.
     *
     * @return Lista de invitaciones de los retrasados.
     */
    public List<Invitacion> obtenerRetrasos() {
        List<Invitacion> retrasados = new ArrayList<>();
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() == EstadoAsistencia.RETRASADO) {
                retrasados.add(i);
            }
        }
        return retrasados;
    }

    /**
     * Obtiene el total de asistentes a la reunion, es decir, los presentes y los retrasados.
     *
     * @return El total de asistentes a la reunion.
     */
    public int obtenerTotalAsistencia() {
        int total = 0;
        for (Invitacion i : listaInvitados) {
            if (i.getEstado() != EstadoAsistencia.AUSENTE) {
                total++;
            }
        }
        return total;
    }

    /**
     * Obtiene el porcentaje de asistencia a la reunion.
     *
     * @return El porcentaje de asistencia de los invitados.
     */
    public float obtenerPorcentajeAsistencia() {
        if (listaInvitados.isEmpty()) return 0;
        return 100f * obtenerTotalAsistencia() / listaInvitados.size();
    }

    /**
     * Genera un informe detallado sobre la reunion, incluyendo la fecha, duracion, asistencia y notas.
     *
     * @return Un String con el informe completo de la reunion.
     */
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

    /**
     * Guarda el informe de la reunion en un archivo de texto especificado por el nombre.
     *
     * @param nombreArchivo El nombre del archivo donde se guardara el informe.
     */
    public void guardarInformeEnArchivo(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(generarInforme());
            System.out.println("Informe guardado en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el informe: " + e.getMessage());
        }
    }

    /**
     * Devuelve Hora de inicio de la reunion.
     *
     * @return Hora de inicio como un Instant.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece hora de inicio de la reunion.
     *
     * @param horaInicio La nueva hora de inicio.
     */
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Devuelve la hora de fin de la reunion.
     *
     * @return La hora de fin como un Instant.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Establece hora de fin de la reunion.
     *
     * @param horaFin Nueva hora fin.
     */
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Devuelve una String de la reunión con sus atributos principales.
     *
     * @return String.
     */
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", organizador=" + organizador +
                ", tipo=" + tipo +
                ", listaInvitados=" + listaInvitados +
                ", notas=" + notas +
                '}';
    }
}