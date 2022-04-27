package cartes;

import joueur.Joueur;
import partie.Partie;

public class CartesPasser extends Cartes{

    public CartesPasser(){
        super(Color.NOIR);
    }

    public Joueur joueurSuivant(Joueur joueur){
        return Partie.getInstance().Suivant(Partie.getInstance().Suivant(joueur));
    }
}
