import java.time.Instant;

public class Invitacion {
    private Invitable invitado;
    private Instant hora;
    private EstadoAsistencia estado;
    private Retraso retraso;

    public Invitacion(Invitable invitado, Instant hora) {
        this.invitado = invitado;
        this.hora = hora;
        this.estado = EstadoAsistencia.AUSENTE;
    }

    public void marcarPresente() {
        this.estado = EstadoAsistencia.PRESENTE;
    }

    public void marcarRetraso(Instant llegada) {
        this.estado = EstadoAsistencia.RETRASADO;
        this.retraso = new Retraso(llegada);
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    public Retraso getRetraso() {
        return retraso;
    }

    public void setRetraso(Retraso retraso) {
        this.retraso = retraso;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public String toString() {
        return invitado.toString() + " - " + estado +
                (retraso != null ? " (llego a: " + retraso.getHora() + ")" : "");
    }
}