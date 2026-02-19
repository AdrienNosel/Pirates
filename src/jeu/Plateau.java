package jeu;

public class Plateau {
    private Case[] cases = new Case[30]; 
    private De de1 = new De();
    private De de2 = new De();
    private De de3 = new De(); // pour le bonus "Prime"

    public Plateau() {
        for (int i = 0; i < 30; i++) {
            if (i == 5 || i == 15) {          // Case 6 et 16  -> Rhum
                cases[i] = new CaseRhum(i + 1);
            } else if (i == 10 || i == 25) {  // Case 11 et 26 -> Pacte
                cases[i] = new CasePacte(i + 1);
            } else {
                cases[i] = new CaseNormale(i + 1);
            }
        }
    }

    public int lancerDes(boolean avecPrime) {
        int deplacement = de1.lancer() + de2.lancer();
        if (avecPrime) {
        	deplacement += de3.lancer();
        }
        return deplacement;
    }
    
    public Case getCase(int index) {
        return cases[index];
    }
//    public int getDes () {
//    	return de1.getValeur() + de2.getValeur();
//    }
}