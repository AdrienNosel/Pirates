package jeu;

import java.util.Random;

public class De {
	private final int NBFACES = 6;
    private int valeur;
    private Random random = new Random();

    public int lancer() {
        this.valeur = random.nextInt(NBFACES) + 1;
        return this.valeur;
    }
}


