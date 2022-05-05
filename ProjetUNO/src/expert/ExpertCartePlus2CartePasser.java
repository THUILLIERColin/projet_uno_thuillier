package expert;

import cartes.Carte;
import cartes.Plus2;
import cartes.CartePasser;
import partie.Partie;

public class ExpertCartePlus2CartePasser extends Expert{

    public ExpertCartePlus2CartePasser(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) throws Exception {
        Partie partie = Partie.getInstance();
        if (carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()){
            return true;
        }
        return false;
    }

    @Override
    public boolean analyse(Carte carte) {
        if(carte instanceof Plus2 && super.getPartie().getPremiereCarteTas() instanceof CartePasser
                || carte instanceof CartePasser && super.getPartie().getPremiereCarteTas() instanceof Plus2)
            return true;
        return false;
    }
}

