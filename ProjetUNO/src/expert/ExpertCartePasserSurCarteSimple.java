package expert;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CarteSimple;
import exceptions.UnoException;
import partie.Partie;

public class ExpertCartePasserSurCarteSimple extends Expert{

    public ExpertCartePasserSurCarteSimple(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) throws Exception {
        Partie partie = Partie.getInstance();

        CartePasser carteJoueur = (CartePasser) carte;
        CarteSimple carteTas = (CarteSimple) super.getPartie().getPremiereCarteTas();
        if ((carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()))
            return true;
        return false;
    }

    @Override
    public boolean analyse(Carte cartes) {
        if(cartes instanceof CartePasser && super.getPartie().getPremiereCarteTas() instanceof CarteSimple)
            return true;
        return false;
    }
}
