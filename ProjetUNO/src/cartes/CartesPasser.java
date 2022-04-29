package cartes;

import joueur.Joueur;
import partie.Partie;

public class CartesPasser extends Cartes{

    public CartesPasser(){
        super(Color.NOIR);
    }

    public Joueur joueurSuivant(){
        Partie partie = Partie.getInstance();
        partie.Suivant();
        return partie.Suivant();
    }

    @Override
    public void effet() throws Exception {

    }
}
