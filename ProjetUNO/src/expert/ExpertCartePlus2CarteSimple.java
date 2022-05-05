package expert;

import cartes.Carte;
import cartes.Plus2;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCartePlus2CarteSimple extends Expert{

    public ExpertCartePlus2CarteSimple(Expert suivant){
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
        if(carte instanceof Plus2 && super.getPartie().getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof Plus2)
            return true;
        return false;
    }
}

