package expert;

import cartes.Carte;
import cartes.Plus2;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCartePlus2CartePlus2 extends Expert{

    public ExpertCartePlus2CartePlus2(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) throws Exception {
        return true;
    }

    @Override
    public boolean analyse(Carte carte) {
        if(carte instanceof Plus2 && super.getPartie().getPremiereCarteTas() instanceof Plus2)
            return true;
        return false;
    }
}

