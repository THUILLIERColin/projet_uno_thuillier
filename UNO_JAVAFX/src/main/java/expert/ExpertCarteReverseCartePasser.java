package expert;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CarteReverse;
import partie.Partie;

public class ExpertCarteReverseCartePasser extends Expert{
    public ExpertCarteReverseCartePasser(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) {
        return true;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        return (carte instanceof CarteReverse && Partie.getInstance().getPremiereCarteTas() instanceof CartePasser
        || carte instanceof CartePasser && Partie.getInstance().getPremiereCarteTas() instanceof CarteReverse);
    }
}

