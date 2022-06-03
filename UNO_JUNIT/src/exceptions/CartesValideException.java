package exceptions;

import cartes.Carte;
import joueur.Joueur;

public class CartesValideException extends Exception{
    private Carte cartesErreur;
    private Joueur mauvaisJoueur;

    /**
     * Exception lorsque une carte est mal jouer
     * @param msg message a afficher
     * @param mauvaisJoueur joueur qui provoque l'erreur
     * @param cartesErreur carte qui provoque l'erreur
     */
    public CartesValideException(String msg, Joueur mauvaisJoueur, Carte cartesErreur){
        super(msg);
        this.mauvaisJoueur=mauvaisJoueur;
        this.cartesErreur = cartesErreur;
    }

    public Carte getCartesErreur() {
        return cartesErreur;
    }
}
