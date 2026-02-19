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
            ihm.attendreAppuiTouche();

            // Avant le tour
            ihm.afficherStatutJoueur(joueurcourant);
            if (joueurcourant.aPrime()) ihm.afficherEvenement(joueurcourant.getNom() + " a pactisé ! Il lancera 3 dés.");
            if (joueurcourant.isIvre()) ihm.afficherEvenement(joueurcourant.getNom() + " titube... il va reculer ce tour-ci !");

            int posDepart = joueurcourant.getPion().getPosition() + 1;
            int deplacement = partie.jouerUnTour(); // Les flags (aPrime/isIvre) passent à false ici
            int posArrivee = joueurcourant.getPion().getPosition() + 1;
            
            // Pendant le tour
            ihm.afficherTour(tour, joueurcourant, posDepart, deplacement, posArrivee);

            // Après le tour
            if (joueurcourant.aPrime()) {
                ihm.afficherEvenement(joueurcourant.getNom() + " a trouvé un accord secret pour son prochain tour ! (-2 PV)");
            }
            if (joueurcourant.isIvre()) {
                ihm.afficherEvenement(joueurcourant.getNom() + " a trouvé du rhum ! Il se soigne (+1 PV) mais attention au prochain tour...");
            }

            tour++;
        }
//        while (!partie.estFini()) {
//            Joueur joueurcourant = partie.getJoueurCourant();
//            
//            ihm.attendreAppuiTouche();
//
//            int posDepart = joueurcourant.getPion().getPosition() + 1;
//            int deplacement = partie.jouerUnTour();
//            int posArrivee = joueurcourant.getPion().getPosition() + 1;
//            
//            ihm.afficherTour(tour, joueurcourant, posDepart, deplacement, posArrivee);
//            tour++;
//        }
        
        ihm.afficherVictoire(partie.getVainqueur());
    }
}
    
