package jeu;

public class Plateau {
    private Case[] cases = new Case[30]; 
    //hypothese : les cases spé seront reconnaisable par leurs index
    // peutetre avoir un tableau pour les cases spé avec leur index 
    private De de1 = new De();
    private De de2 = new De();

    public Plateau() {
        for (int i = 0; i < 30; i++) {
            cases[i] = new Case(i + 1);
        }
    }

    public int lancerDes() {
        de1.lancer();
        de2.lancer();
        return de1.getValeur() + de2.getValeur();
    }
    public int getDes () {
    	return de1.getValeur() + de2.getValeur();
    }
}