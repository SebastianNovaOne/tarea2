import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento dentro de una empresa.
 * Tiene nombre y una lista de empleados de este departamento.
 */
public class Departamento {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();

    /**
     * Crea un nuevo departamento con el nombre especificado.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado El empleado que se desea agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Devuelve la cantidad total de empleados en el departamento.
     *
     * @return La cantidad de empleados.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     * Devuelve el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de empleados del departamento.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Reemplaza la lista de empleados del departamento.
     *
     * @param empleados La nueva lista de empleados.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Devuelve una representacion en texto del departamento,
     * incluyendo nombre y cantidad de empleados.
     *
     * @return Una String con el nombre y cantidad de empleados.
     */
    public String toString() {
        return nombre + " (" + empleados.size() + " empleados)";
    }
}