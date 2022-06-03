package exceptions;

import joueur.Joueur;

public class JoueurException extends Exception{
    Joueur mauvaisJoueur;

    /**
     * Exception lorsqu'un joueur joue au mauvais moment
     * @param msg message a afficher
     * @param mauvaisJoueur joueur qui provoque l'erreur
     */
    public JoueurException(String msg, Joueur mauvaisJoueur){
        super(msg);
        this.mauvaisJoueur=mauvaisJoueur;
    }

    public Joueur getMauvaisJoueur() {
        return mauvaisJoueur;
    }
}
