package expert;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCartePasserCarteSimple extends Expert{

    public ExpertCartePasserCarteSimple(Expert suivant){
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
        return (carte instanceof CartePasser && partie.getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && partie.getPremiereCarteTas() instanceof CartePasser);
    }
}
