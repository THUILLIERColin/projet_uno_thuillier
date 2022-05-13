package expert;

import cartes.Carte;
import cartes.CarteReverse;

public class ExpertCarteReveseCarteSimple extends Expert{
    public ExpertCarteReveseCarteSimple(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){
        return false;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        //return if(carte instanceof CarteReverse);
        return false;
    }
}
