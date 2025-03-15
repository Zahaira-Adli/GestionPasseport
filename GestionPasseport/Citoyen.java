package GestionPasseport;

public class Citoyen {
    private static long compteurId = 1;
    private long id;
    private long numeroCitoyen;
    private String nom;
    private String prenom;
    private int age;
    private Passeport passeport;

    public Citoyen(String nom, String prenom, int age) {
        this.id = compteurId;
        this.numeroCitoyen = compteurId++;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.passeport = null;
    }

//    public Citoyen(long numeroCitoyen, String nom, String prenom, int age) {
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumeroCitoyen() {
        return numeroCitoyen;
    }

    public void setNumeroCitoyen(long numeroCitoyen) {
        this.numeroCitoyen = numeroCitoyen;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Passeport getPasseport() {
        return passeport;
    }

    public void setPasseport(Passeport passeport) {
        this.passeport = passeport;
    }

    @Override
    public String toString() {
        return "Citoyen{" +
                "id=" + id +
                ", numeroCitoyen=" + numeroCitoyen +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", Passeport=" + (passeport != null ? passeport.getNumeroPasseport() : "Aucun") + " }";
    }
}


