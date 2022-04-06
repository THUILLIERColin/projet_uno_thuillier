package cartes;

import joueur.Joueur;
import partie.Partie;

public class Reverse extends Cartes{

    private Color couleur;
    private Joueur joueur;

    public Reverse(Color couleur){
        super(couleur);
    }

    public void Change(Joueur joueur){
        joueur.getPartie().setSens(Partie.SENS_INVERSE);
    }
}
