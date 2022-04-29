package cartes;

import partie.Partie;

public class CartePasser extends Carte {

    public CartePasser(){
        super(Color.NOIR);
    }

    public void joueurSuivant(){
        Partie partie = Partie.getInstance();
        partie.Suivant();
        partie.Suivant();
    }

    @Override
    public void effet() throws Exception {
        joueurSuivant();
    }
}
