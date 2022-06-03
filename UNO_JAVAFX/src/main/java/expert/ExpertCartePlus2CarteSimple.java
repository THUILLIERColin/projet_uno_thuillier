package expert;

import cartes.Carte;
import cartes.CartePlus2;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCartePlus2CarteSimple extends Expert{

    public ExpertCartePlus2CarteSimple(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){
        Partie partie = Partie.getInstance();
        return (carte.getCouleur() == partie.getPremiereCarteTas().getCouleur());
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        Partie partie = Partie.getInstance();
        return (carte instanceof CartePlus2 && partie.getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && partie.getPremiereCarteTas() instanceof CartePlus2);
    }
}

