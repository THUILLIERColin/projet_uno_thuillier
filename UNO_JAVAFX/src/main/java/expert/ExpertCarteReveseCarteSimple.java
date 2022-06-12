package expert;

import cartes.Carte;
import cartes.CarteReverse;
import cartes.CarteSimple;
import partie.Partie;

public class ExpertCarteReveseCarteSimple extends Expert{
    public ExpertCarteReveseCarteSimple(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte){
        return (carte.getCouleur()== Partie.getInstance().getPremiereCarteTas().getCouleur());
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        return (carte instanceof CarteReverse && Partie.getInstance().getPremiereCarteTas() instanceof CarteSimple
                    || carte instanceof CarteSimple && Partie.getInstance().getPremiereCarteTas() instanceof CarteReverse);
    }
}
