package cartes;

import joueur.Joueur;
import partie.Partie;

public class CartesPasser extends Cartes{

    public CartesPasser(){
        super(Color.NOIR);
    }

    public Joueur joueurSuivant(Joueur joueur){
        Partie partie = Partie.getInstance();
        return partie.Suivant(partie.Suivant(joueur));
    }
}
