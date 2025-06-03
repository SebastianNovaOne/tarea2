import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InvitadoExternoTest {

    @Test
    public void testInvitar() {
        InvitadoExterno invitado = new InvitadoExterno("Juan Perez", "juan@correo.com");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        invitado.invitar();

        String output = outContent.toString();
        assertTrue(output.contains("Invitacion enviada a invitado externo: Juan Perez"));
    }
}