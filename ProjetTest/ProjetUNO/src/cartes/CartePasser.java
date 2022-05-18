package cartes;

import partie.Partie;

public class CartePasser extends Carte {

    public CartePasser(Color c){
        super(c);
    }

    /**
     * Change le joueur courante de la partie ne faisant sauter un tour a la personne qui suis le joueur qui a jouer la carte passer
     */
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
