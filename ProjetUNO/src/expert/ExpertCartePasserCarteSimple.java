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
    public boolean expertise(Carte carte) throws Exception {
        Partie partie = Partie.getInstance();

        if (carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()){
            return true;
        }

        return false;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        if(carte instanceof CartePasser && super.getPartie().getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof CartePasser)
            return true;
        return false;
    }
}
