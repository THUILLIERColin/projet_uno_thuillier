package exceptions;

import cartes.Cartes;

public class CartesException extends Exception{
    private Cartes cartesErreur;

    public CartesException(String msg, Cartes cartesErreur){
        super(msg);
        this.cartesErreur = cartesErreur;
    }
}
