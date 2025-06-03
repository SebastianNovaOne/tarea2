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
}