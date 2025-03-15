package GestionPasseport;

public class Passeport {
    private static long compteurId = 1; // ID auto-incrémenté
    private long numeroPasseport;
    private String dateExpiration;
    private Citoyen citoyen;

    public Passeport(long l, String dateExpiration) {
        this.numeroPasseport = compteurId++; // Auto-incrémentation
        this.dateExpiration = dateExpiration;
        this.citoyen = null; // Par défaut, aucun citoyen
    }

    public long getNumeroPasseport() {
        return numeroPasseport;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }

    @Override
    public String toString() {
        return "Passeport{" +
                "numeroPasseport=" + numeroPasseport +
                ", dateExpiration='" + dateExpiration + '\'' +
                ", citoyen=" + (citoyen != null ? citoyen.getNumeroCitoyen() : "Aucun") +
                '}';
    }
}
