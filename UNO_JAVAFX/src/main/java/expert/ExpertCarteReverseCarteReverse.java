package expert;

import cartes.Carte;
import cartes.CarteReverse;
import partie.Partie;

public class ExpertCarteReverseCarteReverse extends Expert{
    public ExpertCarteReverseCarteReverse(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) {
        return true;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        return (carte instanceof CarteReverse && Partie.getInstance().getPremiereCarteTas() instanceof CarteReverse);
    }
}
