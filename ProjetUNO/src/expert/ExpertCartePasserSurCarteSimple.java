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

        if(carte instanceof CartePasser && super.getPartie().getPremiereCarteTas() instanceof CarteSimple){
            CartePasser carteJoueur = (CartePasser) carte;
            CarteSimple carteTas = (CarteSimple) super.getPartie().getPremiereCarteTas();
            if ((carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()))
                return true;
        }
        if(carte instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof CartePasser) {
            CarteSimple carteJoueur = (CarteSimple) carte;
            CartePasser carteTas = (CartePasser) super.getPartie().getPremiereCarteTas();
            if ((carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()))
                return true;
        }
        return false;
    }

    @Override
    public boolean analyse(Carte carte) {
        if(carte instanceof CartePasser && super.getPartie().getPremiereCarteTas() instanceof CarteSimple
                || carte instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof CartePasser)
            return true;
        return false;
    }
}
