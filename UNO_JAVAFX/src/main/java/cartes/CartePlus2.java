package cartes;

import partie.Partie;

public class CartePlus2 extends Carte {

    public CartePlus2(Color c) {
        super(c);
    }

    /**
     * Permet de cumuler le nombre de +2 jouer
     */
    public void plus2Joue() {
        Partie partie = Partie.getInstance();
        partie.setCumulPlus2(partie.getCumulPlus2()+1);
    }


    @Override
    public String toString() {
        return "carte_Plus2_"+ super.getCouleur()+".png";
    }

    @Override
    public void effet() {
        plus2Joue();
    }
}
