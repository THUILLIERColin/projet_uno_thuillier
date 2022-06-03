package expert;

import cartes.Carte;
import cartes.CartePlus2;
import partie.Partie;

public class ExpertCartePlus2CartePlus2 extends Expert{

    public ExpertCartePlus2CartePlus2(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){
        return true;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        Partie partie = Partie.getInstance();
        return(carte instanceof CartePlus2 && partie.getPremiereCarteTas() instanceof CartePlus2);
    }
}

