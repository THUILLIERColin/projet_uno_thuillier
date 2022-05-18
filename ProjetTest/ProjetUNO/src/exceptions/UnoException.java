package exceptions;

import joueur.Joueur;

/**
 * Exception pour l'action UNO
 */
public class UnoException extends Exception{

    private Joueur joueur;

    public UnoException(String msg, Joueur joueur){
        super(msg);
        this.joueur=joueur;
    }
}
