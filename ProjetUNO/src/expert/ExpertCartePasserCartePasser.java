package expert;

import cartes.Carte;
import cartes.CartePasser;
import partie.Partie;

public class ExpertCartePasserCartePasser extends Expert{

    public ExpertCartePasserCartePasser(Expert suivant){ super(suivant);}

    @Override
    public boolean expertise(Carte carte) throws Exception {
        return true;
    }

    @Override
    public boolean analyse(Carte carte) {
        if(carte instanceof CartePasser && Partie.getInstance().getPremiereCarteTas() instanceof CartePasser)
            return true;
        return false;
    }
}
