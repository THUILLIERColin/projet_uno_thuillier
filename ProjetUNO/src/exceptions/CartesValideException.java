package exceptions;

import cartes.Carte;
import joueur.Joueur;

public class CartesValideException extends JoueurException{
    private Carte cartesErreur;

    public CartesValideException(String msg, Joueur mauvaisJoueur, Carte cartesErreur){
        super(msg, mauvaisJoueur);
        this.cartesErreur = cartesErreur;
    }

    public Carte getCartesErreur() {
        return cartesErreur;
    }
}
