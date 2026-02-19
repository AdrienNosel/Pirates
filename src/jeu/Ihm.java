package jeu;

public interface Ihm {
    void afficherDebutPartie();
    void attendreAppuiTouche();
    NomPirate choisirPremierJoueur();
    void afficherTour(int numTour, Joueur j, int posDepart, int deplacement, int posArrivee);
    void afficherVictoire(Joueur vainqueur);
    void afficherEvenement(String message);
    void afficherStatutJoueur(Joueur j);
}