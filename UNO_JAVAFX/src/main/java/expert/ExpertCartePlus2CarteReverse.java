package expert;

import cartes.Carte;
import cartes.CartePlus2;
import cartes.CarteReverse;
import partie.Partie;

public class ExpertCartePlus2CarteReverse extends Expert{
    public ExpertCartePlus2CarteReverse(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) {
        return (carte.getCouleur()==Partie.getInstance().getPremiereCarteTas().getCouleur());
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        Partie partie = Partie.getInstance();
        return (carte instanceof CartePlus2 && partie.getPremiereCarteTas() instanceof CarteReverse
        || carte instanceof CarteReverse && partie.getPremiereCarteTas() instanceof CartePlus2);
    }
}
