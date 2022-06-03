package exceptions;

import joueur.Joueur;

public class UnoException extends Exception{

    private Joueur joueur;

    /**
     * Exception lorsqu'un uno est mal dit ou oublier
     * @param msg message a afficher
     * @param joueur joueur courant
     */
    public UnoException(String msg, Joueur joueur){
        super(msg);
        this.joueur=joueur;
    }
}
