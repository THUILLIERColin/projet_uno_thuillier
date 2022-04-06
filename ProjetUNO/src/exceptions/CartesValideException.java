package exceptions;

import cartes.Cartes;

public class CartesValideException extends Exception{
    private Cartes cartesErreur;

    public CartesValideException(String msg, Cartes cartesErreur){
        super(msg);
        this.cartesErreur = cartesErreur;
    }
}
