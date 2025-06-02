import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DepartamentoTest {

    @Test
    public void testAgregarEmpleado() {
        Departamento depto = new Departamento("Ventas");
        Empleado emp = new Empleado("EMP001", "Garcia", "Luis", "luis.garcia@empresa.com", depto);

        assertEquals(0, depto.obtenerCantidadEmpleados());

        depto.agregarEmpleado(emp);

        assertEquals(1, depto.obtenerCantidadEmpleados());
    }

    @Test
    public void testGetNombre() {
        Departamento depto = new Departamento("Ventas");
        assertEquals("Ventas", depto.getNombre());
    }
}