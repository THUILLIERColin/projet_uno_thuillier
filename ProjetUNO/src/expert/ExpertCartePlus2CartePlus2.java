package expert;

import cartes.Carte;
import cartes.CartePlus2;

public class ExpertCartePlus2CartePlus2 extends Expert{

    public ExpertCartePlus2CartePlus2(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) throws Exception {
        return true;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        if(carte instanceof CartePlus2 && super.getPartie().getPremiereCarteTas() instanceof CartePlus2)
            return true;
        return false;
    }
}

