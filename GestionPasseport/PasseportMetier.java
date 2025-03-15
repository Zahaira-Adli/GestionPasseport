package GestionPasseport;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PasseportMetier {
    private List<Passeport> passeports = new ArrayList<>();
    private static long compteurId = 1;  // Incrémentation automatique des IDs

    public void creerPasseport(String dateExpiration) {
        // Vérification que la date d'expiration est valide
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateExp = LocalDate.parse(dateExpiration, formatter);
        if (dateExp.isBefore(LocalDate.now())) {
            System.out.println("Erreur : La date d'expiration est déjà passée !");
            return;
        }
        Passeport passeport = new Passeport(compteurId++, dateExpiration);
        passeports.add(passeport);
        System.out.println("Passeport créé avec succès : " + passeport);
    }

    public Passeport rechercherPasseport(long numeroPasseport) {
        return passeports.stream()
                .filter(p -> p.getNumeroPasseport() == numeroPasseport)
                .findFirst()
                .orElse(null);
    }

    public List<Passeport> listerPasseports() {
        return passeports;
    }

    public void modifierPasseport(long numeroPasseport, String nouvelleDateExpiration) {
        Passeport passeport = rechercherPasseport(numeroPasseport);
        if (passeport == null) {
            System.out.println("Passeport non trouvé.");
            return;
        }
        // Vérification de la nouvelle date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateExp = LocalDate.parse(nouvelleDateExpiration, formatter);
        if (dateExp.isBefore(LocalDate.now())) {
            System.out.println("Erreur : La nouvelle date d'expiration est déjà passée !");
            return;
        }
        passeport.setDateExpiration(nouvelleDateExpiration);
        System.out.println("Passeport mis à jour avec succès.");
    }

    public void supprimerPasseport(long numeroPasseport) {
        Passeport passeport = rechercherPasseport(numeroPasseport);
        if (passeport == null) {
            System.out.println("Passeport non trouvé.");
            return;
        }
        if (passeport.getCitoyen() != null) {
            System.out.println("Impossible de supprimer un passeport attribué à un citoyen.");
            return;
        }
        passeports.remove(passeport);
        System.out.println("Passeport supprimé avec succès.");
    }

    public List<Passeport> passeportsExpires() {
        List<Passeport> expires = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Passeport p : passeports) {
            LocalDate dateExp = LocalDate.parse(p.getDateExpiration(), formatter);
            if (dateExp.isBefore(LocalDate.now())) {
                expires.add(p);
            }
        }
        return expires;
    }
}
