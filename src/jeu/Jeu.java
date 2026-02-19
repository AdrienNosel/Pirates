package jeu;

public class Jeu {
    private Plateau plateau;
    private Joueur[] joueurs = new Joueur[2];
    private int indexJoueurCourant = 0;

    public Jeu() {
        this.plateau = new Plateau();
    }
    
    public Joueur getJoueurCourant() {
        return joueurs[indexJoueurCourant];
    }

    public void initJoueurs(NomPirate premierChoix) {
        if (premierChoix == NomPirate.JACK_LE_BORGNE) {
            joueurs[0] = new Joueur(NomPirate.JACK_LE_BORGNE, CouleurPion.ROUGE);
            joueurs[1] = new Joueur(NomPirate.BILL_JAMBE_DE_BOIS, CouleurPion.BLEU);
        } 
        else {
            joueurs[0] = new Joueur(NomPirate.BILL_JAMBE_DE_BOIS, CouleurPion.BLEU);
            joueurs[1] = new Joueur(NomPirate.JACK_LE_BORGNE, CouleurPion.ROUGE);
        }
    }

    public int jouerUnTour() {
    	//Init
        Joueur joueur = getJoueurCourant();
        int deplacement = plateau.lancerDes(joueur.aPrime());
        
        //Gestion des etats du joueur
        if (joueur.aPrime()) {
            joueur.setAPrime(false);
        }
        if (joueur.isIvre()) {
            deplacement = -deplacement; 
            joueur.setIvre(false);     
        }
        //Deplacement
        joueur.deplacer(deplacement);

        //Consequence du deplacement
        Case caseArrivee = plateau.getCase(joueur.getPion().getPosition());
        caseArrivee.appliquerEffet(joueur);

        //Init tour suivant
        indexJoueurCourant = (indexJoueurCourant + 1) % 2;

        return deplacement;
    }

    public boolean estFini() {
        return joueurs[0].estElimine() || 
        		joueurs[1].estElimine() ||
        		joueurs[0].getPion().getPosition() == 29 || 
        		joueurs[1].getPion().getPosition() == 29;
    }
    public Joueur getVainqueur() {
        if (joueurs[0].getPion().getPosition() == 29) {
            return joueurs[0];
        } else if (joueurs[1].getPion().getPosition() == 29) {
            return joueurs[1];
        }
        
        if (joueurs[0].estElimine()) return joueurs[1];
        if (joueurs[1].estElimine()) return joueurs[0];

        return null;
    }
}