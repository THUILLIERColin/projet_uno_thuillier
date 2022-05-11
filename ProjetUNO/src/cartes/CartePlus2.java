package cartes;

import partie.Partie;

public class CartePlus2 extends Carte {

    private int nbPlus2Pose=0;

    public CartePlus2(Color c) {
        super(c);
    }

    public void plus2Joue() {
        nbPlus2Pose++;
    }

    public int getNbPlus2Pose() {
        return nbPlus2Pose*2;
    }

    @Override
    public String toString() {
        return "CartePlus2" + " "+ super.getCouleur();
    }

    @Override
    public void effet() throws Exception {
        plus2Joue();
    }
}
