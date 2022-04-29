package exceptions;

import cartes.Carte;

public class CartesValideException extends Exception{
    private Carte cartesErreur;

    public CartesValideException(String msg, Carte cartesErreur){
        super(msg);
        this.cartesErreur = cartesErreur;
    }
}
