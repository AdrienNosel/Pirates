package jeu;

//import java.util.Scanner;

public class TestJeu {
    public static void main(String[] args) {
        Ihm ihm = new ConsoleIhm(); 
        Jeu partie = new Jeu();

        ihm.afficherDebutPartie();
        NomPirate premier = ihm.choisirPremierJoueur();
        partie.initJoueurs(premier);
        int tour = 1;
        
        while (!partie.estFini()) {
            Joueur joueurcourant = partie.getJoueurCourant();
            int posDepart = joueurcourant.getPion().getPosition() + 1;

            int deplacement = partie.jouerUnTour();
            int posArrivee = joueurcourant.getPion().getPosition() + 1;
            
            ihm.afficherTour(tour, joueurcourant, posDepart, deplacement, posArrivee);
            
            tour++;
        }
        
        ihm.afficherVictoire(partie.getVainqueur());
    }
}
    
    
    
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Jeu partie = new Jeu();
//
//        System.out.println("--- BIENVENUE DANS LE JEU DES PIRATES ---");
//        System.out.println("Qui doit commencer ?");
//        System.out.println("1. JACK_LE_BORGNE");
//        System.out.println("2. BILL_JAMBE_DE_BOIS");
//        
//        int choix = scanner.nextInt();
//        NomPirate premier = (choix == 1) ? NomPirate.JACK_LE_BORGNE : NomPirate.BILL_JAMBE_DE_BOIS;
//        
//        partie.initJoueurs(premier);
//        System.out.println("\nLa partie commence avec " + premier + " !\n");
//
//        int tour = 1;
//        while (!partie.estFini()) {
//            Joueur joueurcourant = partie.getJoueurCourant();
//            int posDepart = joueurcourant.getPion().getPosition() + 1; // +1 car index 0 = Case 1
//
//            System.out.println("Tour n°" + tour + " - C'est au tour de : " + joueurcourant.getNom());
//            
//            int deplacement = partie.jouerUnTour();
//            
//            int posArrivee = joueurcourant.getPion().getPosition() + 1;
//            
//            System.out.println(joueurcourant.getNom() + " était sur la case " + posDepart);
//            System.out.println("Il a fait " + deplacement + " avec ses dés.");
//            System.out.println("Résultat du déplacement -> Nouvelle case : " + posArrivee);
//            System.out.println("-------------------------------------------");
//            
//            tour++;
//        }
//        System.out.println("\n!!! LA PARTIE EST TERMINÉE !!!");
//        Joueur joueurcourant = partie.getJoueurCourant();
//        System.out.println(joueurcourant.getNom() + "a gagné la partie.");
//        
//        scanner.close();
//    }
//}