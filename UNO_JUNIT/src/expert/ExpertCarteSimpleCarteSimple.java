package expert;

import cartes.Carte;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCarteSimpleCarteSimple extends Expert{

    public ExpertCarteSimpleCarteSimple(Expert suivant){
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){

        Partie partie = Partie.getInstance();

        CarteSimple carteJoueur = (CarteSimple) carte;
        CarteSimple carteTas = (CarteSimple) partie.getPremiereCarteTas();
        return ((carte.getCouleur() == partie.getPremiereCarteTas().getCouleur()) || (carteJoueur.getNumero() == carteTas.getNumero()));
    }

    @Override
    public boolean saitExpertiser(Carte cartes) {
         return (cartes instanceof CarteSimple && Partie.getInstance().getPremiereCarteTas() instanceof CarteSimple) ;
    }
}
