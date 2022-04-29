package cartes;

import partie.Partie;

public class Plus2 extends Carte {

    public Plus2() {
        super(Color.NOIR);
    }

    public void prendre2() throws Exception{
        for(int i=0; i< 2; i++)
            Partie.getInstance().getJoueurCourant().piocher();
    }

    @Override
    public void effet() throws Exception {
        prendre2();
    }
}
