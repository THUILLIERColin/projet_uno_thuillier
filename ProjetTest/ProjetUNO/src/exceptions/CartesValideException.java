package exceptions;

import cartes.Carte;
import joueur.Joueur;

/**
 * Exception pour els cartes valide
 */
public class CartesValideException extends Exception{
    private Carte cartesErreur;
    private Joueur mauvaisJoueur;

    public CartesValideException(String msg, Joueur mauvaisJoueur, Carte cartesErreur){
        super(msg);
        this.mauvaisJoueur=mauvaisJoueur;
        this.cartesErreur = cartesErreur;
    }

    public Carte getCartesErreur() {
        return cartesErreur;
    }
}
