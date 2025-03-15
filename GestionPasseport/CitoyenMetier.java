package GestionPasseport;

import java.util.ArrayList;
import java.util.List;

public class CitoyenMetier {
    private List<Citoyen> citoyens = new ArrayList<>();
    private static long compteurId = 1;  // Incrémentation automatique des IDs

    public void creerCitoyen(String nom, String prenom, int age) {
        Citoyen citoyen = new Citoyen(nom, prenom, age);
        citoyens.add(citoyen);
        System.out.println("Citoyen créé avec succès : " + citoyen);
    }

    public Citoyen rechercherCitoyen(long numeroCitoyen) {
        return citoyens.stream()
                .filter(c -> c.getNumeroCitoyen() == numeroCitoyen)
                .findFirst()
                .orElse(null);
    }

    public List<Citoyen> listerCitoyens() {
        return citoyens;
    }

    public void supprimerCitoyen(long numeroCitoyen) {
        Citoyen citoyen = rechercherCitoyen(numeroCitoyen);
        if (citoyen == null) {
            System.out.println("Citoyen non trouvé.");
            return;
        }
        if (citoyen.getPasseport() != null) {
            System.out.println("Suppression du passeport associé...");
            citoyen.getPasseport().setCitoyen(null);
        }
        citoyens.remove(citoyen);
        System.out.println("Citoyen supprimé avec succès.");
    }

    public void attribuerPasseport(long numeroCitoyen, Passeport passeport) {
        Citoyen citoyen = rechercherCitoyen(numeroCitoyen);
        if (citoyen == null) {
            System.out.println("Citoyen non trouvé.");
            return;
        }
        if (passeport.getCitoyen() != null) {
            System.out.println("Ce passeport est déjà attribué à un autre citoyen.");
            return;
        }
        citoyen.setPasseport(passeport);
        passeport.setCitoyen(citoyen);
        System.out.println("Passeport attribué avec succès au citoyen: " + citoyen);
    }

    public Citoyen rechercherCitoyenParPasseport(long numeroPasseport) {
        for (Citoyen c : citoyens) {
            if (c.getPasseport() != null && c.getPasseport().getNumeroPasseport() == numeroPasseport) {
                return c;
            }
        }
        return null;
    }

    public Passeport rechercherPasseportParNumeroCitoyen(long numeroCitoyen) {
        Citoyen c = rechercherCitoyen(numeroCitoyen);
        return (c != null) ? c.getPasseport() : null;
    }
}
