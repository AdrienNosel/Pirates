package jeu;

public class Joueur {
    private NomPirate nom;
    private CouleurPion couleur;
    private int pointsDeVie = 5;
    private Pion pion;

    public Joueur(NomPirate nom, CouleurPion couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.pion = new Pion();
    }
    
    //Getters--------------------------------------
    public NomPirate getNom() { 
    	return nom; 
    }
    public Pion getPion() { 
    	return pion; 
    }
    public int getPointsDeVie() { 
    	return pointsDeVie; 
    }
    //---------------------------------------------
    
    //Methods--------------------------------------
    public void deplacer(int deplacement) {
        int posActuelle = pion.getPosition();
        int cible = posActuelle + deplacement;
        
        // Rebond si >30
        if (cible > 29) {
            int depassement = cible - 29;
            cible = 29 - depassement;
        }
        
        pion.setPosition(cible);
    }

    public void subirDegats(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
        	this.pointsDeVie = 0;
        }
    }

    public boolean estElimine() {
        return this.pointsDeVie <= 0;
    }
    //---------------------------------------------
}