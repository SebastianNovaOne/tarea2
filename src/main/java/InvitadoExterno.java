public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;

    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }
}
