package cartes;

import joueur.Joueur;

public class Plus2 extends Cartes{

    public Plus2() {
        super(Color.NOIR);
    }

    public void prendre2(Joueur joueur) throws Exception{
        for(int i=0; i< 2; i++)
        joueur.piocher();
    }

}
