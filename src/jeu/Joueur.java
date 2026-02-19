package jeu;

public class Joueur {
    private NomPirate nom;
    private CouleurPion couleur;
    private int pointsDeVie = 5;
    private Pion pion;
    
    private int toursAAttendre = 0;    // Pour le Kraken
    private boolean aPrime = false;    // Pour le Pacte du Corsaire
    private boolean estIvre = false;   // Pour le Rhum

    public Joueur(NomPirate nom, CouleurPion couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.pion = new Pion();
    }
    
    //Getters-Setters--------------------------------------
    public NomPirate getNom() { 
    	return nom; 
    }
    public Pion getPion() { 
    	return pion;
    }
    public int getPointsDeVie() { 
    	return pointsDeVie; 
    }
    
    public int getToursAAttendre() { 
    	return toursAAttendre; 
    }
    public void setToursAAttendre(int tours) { 
    	this.toursAAttendre = tours; 
    }

    public boolean aPrime() { 
    	return aPrime; 
    }
    public void setAPrime(boolean bonus) { 
    	this.aPrime = bonus; 
    }

    public boolean isIvre() { 
    	return estIvre; 
    }
    public void setIvre(boolean ivre) { 
    	this.estIvre = ivre; 
    }
    //---------------------------------------------
    
    //Methods--------------------------------------
    public void deplacer(int deplacement) {
        int posActuelle = pion.getPosition();
        int cible = posActuelle + deplacement;
        
        if (cible < 0 ) {
        	cible = 0;
        }
        if (cible > 29) {
            int depassement = cible - 29;
            cible = 29 - depassement;
        }
        
        pion.setPosition(cible);
    }

    public void modifierPointsDeVie(int delta) {
        this.pointsDeVie += delta;
        if (this.pointsDeVie < 0) this.pointsDeVie = 0;
        if (this.pointsDeVie > 5) this.pointsDeVie = 5;
    }

    public boolean estElimine() {
        return this.pointsDeVie <= 0;
    }
    //---------------------------------------------
}

