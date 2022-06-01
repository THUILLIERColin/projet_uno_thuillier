package cartes;

import partie.Partie;

public class CartePasser extends Carte {

    public CartePasser(Color c){
        super(c);
    }

    public void joueurSuivant(){
        Partie partie = Partie.getInstance();
        partie.getJoueurCourant().setPasser(true);
    }

    @Override
    public void effet() throws Exception {
        joueurSuivant();
    }

    @Override
    public String toString() {
        return "Passe ton tour "+ getCouleur();
    }
}
