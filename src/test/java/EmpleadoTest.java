import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    @Test
    public void testGetNombreCompleto() {
        Departamento depto = new Departamento("Marketing");
        Empleado emp = new Empleado("EMP001", "Perez", "Maria", "maria@empresa.com", depto);

        String resultado = emp.getNombreCompleto();

        assertEquals("Maria Perez", resultado);
    }
}