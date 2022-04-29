package cartes;

import joueur.Joueur;
import partie.Partie;

public class Plus2 extends Cartes{

    public Plus2(Color c) {
        super(c);
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
