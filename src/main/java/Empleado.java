/**
 * Representa un empleado de una empresa.
 * Cada empleado tiene ID, nombre, apellidos, correo electrónico y departamento al que pertenece.
 * Esta clase implementa la interfaz @code Invitable, lo que permite que sea invitado a reuniones.
 */
public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;

    /**
     * Crea un nuevo empleado con los datos especificados.
     *
     * @param id El identificador online del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre El nombre del empleado.
     * @param correo El correo electronico del empleado.
     * @param departamento El departamento al que pertenece el empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    /**
     * Devuelve el ID del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id El nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve los apellidos del empleado.
     *
     * @return Los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Los nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo del empleado.
     *
     * @return El correo del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del empleado.
     *
     * @param correo El nuevo correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el departamento al que pertenece el empleado.
     *
     * @return El departamento del empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del empleado.
     *
     * @param departamento El nuevo departamento.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve el nombre completo del empleado (nombre + apellidos).
     *
     * @return El nombre completo del empleado.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    /**
     * Imprime un mensaje de invitacion para el empleado.
     * Implementacion del metodo @code invitar() de la interfaz @code Invitable.
     */
    public void invitar() {
        System.out.println("Invitacion enviada a empleado: " + getNombreCompleto());
    }

    /**
     * Devuelve una representacion en texto del empleado.
     * Incluye nombre completo y correo electronico.
     *
     * @return Una String con el nombre completo y el correo del empleado.
     */
    public String toString() {
        return getNombreCompleto() + " (" + correo + ")";
    }
}

