/**
 * Representa un invitado externo a una reunion.
 * Esta clase implementa la interfaz {@link Invitable} y permite enviar una invitacion
 * y representar al invitado externo con su nombre completo y correo.
 *
 * @see Invitable
 */
public class InvitadoExterno implements Invitable {
    /**
     * El nombre completo del invitado.
     */
    private String nombreCompleto;

    /**
     * El correo electronico del invitado.
     */
    private String correo;

    /**
     * Crea un nuevo invitado externo con el nombre completo y correo especificados.
     *
     * @param nombreCompleto Nombre completo del invitado.
     * @param correo Correo electronico del invitado.
     */
    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    /**
     * Envia una invitacion al invitado externo.
     * Este metodo imprime un mensaje indicando que la invitacion ha sido enviada.
     */
    public void invitar() {
        System.out.println("Invitacion enviada a invitado externo: " + nombreCompleto);
    }

    /**
     * Devuelve una representacion en String del invitado externo.
     * Incluye el nombre completo y el correo electronico.
     *
     * @return Una String que representa al invitado externo.
     */
    public String toString() {
        return nombreCompleto + "(Invitado Externo - " + correo + ")";
    }
}