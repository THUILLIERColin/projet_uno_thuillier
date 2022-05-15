package exceptions;

import joueur.Joueur;

public class UnoException extends Exception{

    private Joueur joueur;

    public UnoException(String msg, Joueur joueur){
        super(msg);
        this.joueur=joueur;
    }
}
