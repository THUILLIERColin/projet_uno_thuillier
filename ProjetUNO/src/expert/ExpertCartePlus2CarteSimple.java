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
    public boolean expertise(Carte carte) throws Exception {
        Partie partie = Partie.getInstance();
        if (carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()){
            return true;
        }
        return false;
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        //faire variable partie.getinstance
        if(carte instanceof CartePlus2 && Partie.getInstance().getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof CartePlus2)
            return true;
        return false;
    }
}

