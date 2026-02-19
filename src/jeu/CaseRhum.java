package jeu;

public class CaseRhum extends Case {
    public CaseRhum(int numero) {
        super(numero);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.modifierPointsDeVie(1);
        joueur.setIvre(true);
    }
}