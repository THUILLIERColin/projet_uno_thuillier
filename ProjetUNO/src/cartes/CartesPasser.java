package cartes;

import joueur.Joueur;
import partie.Partie;

public class CartesPasser extends Cartes{

    public CartesPasser(Color couleur){
        super(couleur);
    }

    public void joueurSuivant(){
        Partie partie = Partie.getInstance();
        partie.Suivant();
        partie.Suivant();
    }

    @Override
    public void effet() throws Exception {
        joueurSuivant();
    }
}
