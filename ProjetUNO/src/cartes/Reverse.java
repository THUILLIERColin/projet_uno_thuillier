package cartes;

import joueur.Joueur;
import partie.Partie;

public class Reverse extends Cartes{
    //CONSTRUCTEUR
    public Reverse(Color c) {
        super(c);
    }

    public Reverse(Reverse r){
        super(r.getCouleur());
    }

    //EQUALS + TOSTRING
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reverse that = (Reverse) o;
        return super.getCouleur()==that.getCouleur();
    }

    @Override
    public String toString() {
        return "Reverse[ Couleur : "+super.getCouleur()+" ]";
    }

    //AUTRE
    public void ChangeDeSens(Joueur j){
        if(j.getPartie().getSens == Partie.SENS_INVERSE){
            j.getPartie().setSens == Partie.AIGUILLE_MONTRE;
        }
        j.getPartie().setSens == Partie.SENS_INVERSE;
    }
}
