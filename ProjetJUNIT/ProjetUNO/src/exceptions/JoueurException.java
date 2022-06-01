package exceptions;

import joueur.Joueur;

public class JoueurException extends Exception{
    Joueur mauvaisJoueur;

    public JoueurException(String msg, Joueur mauvaisJoueur){
        super(msg);
        this.mauvaisJoueur=mauvaisJoueur;
    }

    public Joueur getMauvaisJoueur() {
        return mauvaisJoueur;
    }
}
