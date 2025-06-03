public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;

    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public void invitar() {
        System.out.println("Invitacion enviada a invitado externo: " + nombreCompleto);
    }

    public String toString() {
        return nombreCompleto + "(Invitado Externo - " + correo + ")";
    }
}
