package jeu;

public interface Ihm {
    void afficherDebutPartie();
    NomPirate choisirPremierJoueur();
    void afficherTour(int numTour, Joueur j, int posDepart, int deplacement, int posArrivee);
    void afficherVictoire(Joueur vainqueur);
}