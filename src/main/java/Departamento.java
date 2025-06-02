import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
}
