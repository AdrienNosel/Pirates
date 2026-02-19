package jeu;

public abstract class Case {
    private int numero;
    
    public Case (int numero) { 
        this.numero = numero; 
    }

    public int getNumero() {
        return numero;
    }

    public abstract void appliquerEffet(Joueur joueur);
}