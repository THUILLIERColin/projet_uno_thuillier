package expert;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CartePlus2;
import partie.Partie;

public class ExpertCartePlus2CartePasser extends Expert{

    public ExpertCartePlus2CartePasser(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){
        Partie partie = Partie.getInstance();
        return(carte.getCouleur() == partie.getPremiereCarteTas().getCouleur());
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        Partie partie = Partie.getInstance();
        return (carte instanceof CartePlus2 && partie.getPremiereCarteTas() instanceof CartePasser
                || carte instanceof CartePasser && partie.getPremiereCarteTas() instanceof CartePlus2);
    }
}

