package jeu;
import java.util.Scanner;

public class ConsoleIhm implements Ihm {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherDebutPartie() {
        System.out.println("--- BIENVENUE DANS LE JEU DES PIRATES ---");
    }
    
    @Override
    public void attendreAppuiTouche() {
        System.out.print("\n> Appuyez sur [ENTRÉE] pour le tour suivant...\n");
        scanner.nextLine(); 
    }

    @Override
    public NomPirate choisirPremierJoueur() {
        System.out.println("Qui doit commencer ?\n1. JACK_LE_BORGNE\n2. BILL_JAMBE_DE_BOIS");
        int choix = scanner.nextInt();
        scanner.nextLine();
        return (choix == 1) ? NomPirate.JACK_LE_BORGNE : NomPirate.BILL_JAMBE_DE_BOIS;
    }

    @Override
    public void afficherTour(int numTour, Joueur j, int posDepart, int deplacement, int posArrivee) {
        System.out.println("Tour n°" + numTour + " - C'est au tour de : " + j.getNom());
        System.out.println("Il était sur la case " + posDepart);
        System.out.println("Il a fait " + deplacement + " avec ses dés.");
        System.out.println("Résultat du déplacement -> Nouvelle case : " + posArrivee);
        System.out.println("-------------------------------------------");
    }
    
    @Override
    public void afficherVictoire(Joueur vainqueur) {
        System.out.println("\n!!! LA PARTIE EST TERMINÉE !!!");
        if (vainqueur != null) {
            System.out.println(vainqueur.getNom() + " a gagné la partie.");
        } else {
            System.out.println("Match nul !");
        }
    }
}