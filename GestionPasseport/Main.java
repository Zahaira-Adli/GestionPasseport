package GestionPasseport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CitoyenMetier citoyenMetier = new CitoyenMetier();
        PasseportMetier passeportMetier = new PasseportMetier();

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion des citoyens");
            System.out.println("2. Gestion des passeports");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    menuCitoyens(scanner, citoyenMetier, passeportMetier);
                    break;
                case 2:
                    menuPasseports(scanner, passeportMetier, citoyenMetier);
                    break;
                case 3:
                    System.out.println("Merci d'utiliser le système de gestion des passeports.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private static void menuCitoyens(Scanner scanner, CitoyenMetier citoyenMetier, PasseportMetier passeportMetier) {
        while (true) {
            System.out.println("\n--- Gestion des Citoyens ---");
            System.out.println("1. Ajouter un citoyen");
            System.out.println("2. Rechercher un citoyen");
            System.out.println("3. Afficher tous les citoyens");
            System.out.println("4. Supprimer un citoyen");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Âge : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    citoyenMetier.creerCitoyen(nom, prenom, age);
                    break;

                case 2:
                    System.out.print("Entrez le numéro du citoyen : ");
                    long numero = scanner.nextLong();
                    scanner.nextLine();
                    Citoyen citoyen = citoyenMetier.rechercherCitoyen(numero);
                    System.out.println((citoyen != null) ? citoyen : "Citoyen introuvable.");
                    break;

                case 3:
                    citoyenMetier.listerCitoyens().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Entrez le numéro du citoyen à supprimer : ");
                    long numSuppr = scanner.nextLong();
                    scanner.nextLine();
                    citoyenMetier.supprimerCitoyen(numSuppr);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private static void menuPasseports(Scanner scanner, PasseportMetier passeportMetier, CitoyenMetier citoyenMetier) {
        while (true) {
            System.out.println("\n--- Gestion des Passeports ---");
            System.out.println("1. Ajouter un passeport");
            System.out.println("2. Rechercher un passeport");
            System.out.println("3. Afficher tous les passeports");
            System.out.println("4. Supprimer un passeport");
            System.out.println("5. Attribuer un passeport à un citoyen");
            System.out.println("6. Retour au menu principal");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Date d'expiration (dd/MM/yyyy) : ");
                    String dateExp = scanner.nextLine();
                    passeportMetier.creerPasseport(dateExp);
                    break;

                case 2:
                    System.out.print("Entrez le numéro du passeport : ");
                    long numPasseport = scanner.nextLong();
                    scanner.nextLine();
                    Passeport passeport = passeportMetier.rechercherPasseport(numPasseport);
                    System.out.println((passeport != null) ? passeport : "Passeport introuvable.");
                    break;

                case 3:
                    passeportMetier.listerPasseports().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Entrez le numéro du passeport à supprimer : ");
                    long numSuppr = scanner.nextLong();
                    scanner.nextLine();
                    passeportMetier.supprimerPasseport(numSuppr);
                    break;

                case 5:
                    System.out.print("Entrez le numéro du citoyen : ");
                    long numCitoyen = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le numéro du passeport : ");
                    long numPasseportAttrib = scanner.nextLong();
                    scanner.nextLine();
                    Passeport passeportAttrib = passeportMetier.rechercherPasseport(numPasseportAttrib);
                    citoyenMetier.attribuerPasseport(numCitoyen, passeportAttrib);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
