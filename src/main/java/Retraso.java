import java.time.Instant;

/**
 * Representa un atraso en la llegada de un invitado a la reunion.
 * Guarda la hora en la que llego el invitado atrasado.
 */
public class Retraso {
    private Instant hora;

    /**
     * Crea un nuevo objeto de tipo Retraso con la hora especificada.
     *
     * @param hora La hora a la que llego el invitado.
     */
    public Retraso(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve la hora a la que llego el invitado.
     *
     * @return La hora de llegada.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Establece la hora a la que llego el invitado.
     *
     * @param hora La nueva hora de llegada.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve una representacion en texto del retraso.
     *
     * @return Una String que describe el retraso con la hora de llegada.
     */
    public String toString() {
        return "Retraso{" + "hora=" + hora + "}";
    }
}