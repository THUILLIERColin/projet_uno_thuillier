package cartes;

import partie.Partie;

public class CartePasser extends Carte {

    public CartePasser(Color c){
        super(c);
    }

    /**
     * Change le prochain joueur en sautant un tour
     */
    public void joueurSuivant(){
        Partie partie = Partie.getInstance();
        partie.getJoueurCourant().setPasser(true);
    }

    @Override
    public void effet() {
        joueurSuivant();
    }

    @Override
    public String toString() {
        return "carte_Passe_"+ getCouleur()+".png";
    }
}
