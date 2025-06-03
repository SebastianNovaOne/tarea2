import java.time.Instant;

/**
 * Representa una invitacion a una reunion para un {@link Invitable}.
 * Permite marcar el estado de la asistencia de la persona invitada, como "presente", "ausente" o "retrasado".
 *
 * @see Invitable
 * @see EstadoAsistencia
 * @see Retraso
 */
public class Invitacion {

    /**
     * El invitado a la reunion. Implementa la interfaz {@link Invitable}.
     */
    private Invitable invitado;

    /**
     * La hora en la que se registro la invitacion.
     */
    private Instant hora;

    /**
     * El estado de la asistencia del invitado a la reunion.
     * Puede ser PRESENTE, AUSENTE o RETRASADO.
     */
    private EstadoAsistencia estado;

    /**
     * La informacion del retraso del invitado (si aplica).
     */
    private Retraso retraso;

    /**
     * Crea una nueva invitacion para el invitado y la hora de la reunion.
     * El estado de la invitacion se establece por defecto como AUSENTE.
     *
     * @param invitado El invitado a la reunion.
     * @param hora La hora en la que se registro la invitacion.
     */
    public Invitacion(Invitable invitado, Instant hora) {
        this.invitado = invitado;
        this.hora = hora;
        this.estado = EstadoAsistencia.AUSENTE;
    }

    /**
     * Marca al invitado como presente en la reunion.
     */
    public void marcarPresente() {
        this.estado = EstadoAsistencia.PRESENTE;
    }

    /**
     * Marca al invitado como retrasado, registrando la hora de llegada.
     *
     * @param llegada La hora en la que el invitado llego tarde a la reunion.
     */
    public void marcarRetraso(Instant llegada) {
        this.estado = EstadoAsistencia.RETRASADO;
        this.retraso = new Retraso(llegada);
    }

    /**
     * Devuelve el invitado de la invitacion.
     *
     * @return El invitado.
     */
    public Invitable getInvitado() {
        return invitado;
    }

    /**
     * Establece el invitado de la invitacion.
     *
     * @param invitado El nuevo invitado.
     */
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }

    /**
     * Devuelve el estado de la invitacion.
     *
     * @return El estado de la invitacion.
     */
    public EstadoAsistencia getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la invitacion.
     *
     * @param estado El nuevo estado de la invitacion.
     */
    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el retraso registrado para el invitado (si aplica).
     *
     * @return El retraso.
     */
    public Retraso getRetraso() {
        return retraso;
    }

    /**
     * Establece el retraso del invitado.
     *
     * @param retraso El nuevo retraso.
     */
    public void setRetraso(Retraso retraso) {
        this.retraso = retraso;
    }

    /**
     * Devuelve la hora en la que se registro la invitacion.
     *
     * @return La hora de la invitacion.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Establece la hora de la invitacion.
     *
     * @param hora La nueva hora.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve una representacion en String de la invitacion.
     * Incluye el nombre del invitado, su estado de asistencia y la hora de llegada en caso de retraso.
     *
     * @return Una String que describe la invitacion.
     */
    public String toString() {
        return invitado.toString() + " - " + estado +
                (retraso != null ? " (llego a: " + retraso.getHora() + ")" : "");
    }
}