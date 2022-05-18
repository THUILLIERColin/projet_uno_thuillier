package cartes;

import partie.Partie;

public class CartePlus2 extends Carte {

    public CartePlus2(Color c) {
        super(c);
    }

    /**
     * Permet de savoir combien de carte +2 on était jouer et les cumuls si besoin
     */
    public void plus2Joue() {
        Partie partie = Partie.getInstance();
        partie.setCumulPlus2(partie.getCumulPlus2()+1);
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
