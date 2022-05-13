package expert;

import cartes.CarteSimple;
import cartes.Carte;
import partie.Partie;

public class ExpertCarteSimpleCarteSimple extends Expert{

    public ExpertCarteSimpleCarteSimple(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) throws Exception {

        Partie partie = Partie.getInstance();

        CarteSimple carteJoueur = (CarteSimple) carte;
        CarteSimple carteTas = (CarteSimple) super.getPartie().getPremiereCarteTas();
        if ((carte.getCouleur() == super.getPartie().getPremiereCarteTas().getCouleur()) || (carteJoueur.getNumero() == carteTas.getNumero()))
            return true;
                // C'est un class Carte et il n'existe pas de getNumero() dedans, il faudrait convertir en CarteSimple
                // Ou bien recevoir directement une carte simple
        return false;
    }

    @Override
    public boolean saitExpertiser(Carte cartes) {
        if(cartes instanceof CarteSimple && super.getPartie().getPremiereCarteTas() instanceof CarteSimple)
            return true;
        return false;
    }

}
