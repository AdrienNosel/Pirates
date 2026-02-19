package jeu;

public class CasePacte extends Case {
    public CasePacte(int numero) {
        super(numero);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.modifierPointsDeVie(-2);
        joueur.setAPrime(true); 
    }
}