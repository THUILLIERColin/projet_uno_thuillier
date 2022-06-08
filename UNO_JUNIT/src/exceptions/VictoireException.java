package exceptions;

import joueur.Joueur;

public class VictoireException extends Exception{

    Joueur joueurVainqueur;

    public VictoireException(Joueur joueur){
        this.joueurVainqueur=joueur;
    }

    public Joueur getJoueurVainqueur() {
        return joueurVainqueur;
    }
}
