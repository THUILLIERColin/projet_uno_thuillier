package expert;

import cartes.Carte;

public class ExpertCartePasserCartePasser extends Expert{

    public ExpertCartePasserCartePasser(Expert suivant){ super(suivant);}

    @Override
    public boolean expertise(Carte cartes) throws Exception {
        return false;
    }

    @Override
    public boolean analyse(Carte cartes) {
        if()
        return false;
    }
}
