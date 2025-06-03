import org.junit.jupiter.api.Test;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class InvitacionTest {

    @Test
    public void testMarcarPresente() {
        InvitadoExterno invitado = new InvitadoExterno("Ana Gomez", "ana@correo.com");
        Invitacion invitacion = new Invitacion(invitado, Instant.now());

        invitacion.marcarPresente();

        assertEquals(EstadoAsistencia.PRESENTE, invitacion.getEstado());
    }

    @Test
    public void testMarcarRetraso() {
        InvitadoExterno invitado = new InvitadoExterno("Carlos Ruiz", "carlos@correo.com");
        Invitacion invitacion = new Invitacion(invitado, Instant.now());

        Instant llegadaTarde = Instant.now().plusSeconds(300);
        invitacion.marcarRetraso(llegadaTarde);

        assertEquals(EstadoAsistencia.RETRASADO, invitacion.getEstado());
        assertEquals(llegadaTarde, invitacion.getRetraso().getHora());
    }
}