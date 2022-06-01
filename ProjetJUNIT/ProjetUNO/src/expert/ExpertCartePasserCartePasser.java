package expert;

import cartes.Carte;
import cartes.CartePasser;
import partie.Partie;

public class ExpertCartePasserCartePasser extends Expert{

    public ExpertCartePasserCartePasser(Expert suivant){ super(suivant);}

    @Override
    public boolean expertise(Carte carte) {
        return true;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        return(carte instanceof CartePasser && Partie.getInstance().getPremiereCarteTas() instanceof CartePasser);
    }
}
