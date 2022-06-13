package cartes;

import partie.Partie;

public class CarteReverse extends Carte {

    //CONSTRUCTEUR
    public CarteReverse(Color c) {
        super(c);
    }


    // PEUT-ETRE ENLEVER LE BOOL SENS ET FOURNIR A LA FONCTION LA LISTE DES JOUEURS

    /**
     * Change le sens de jeu dans la partie
     */
    public void ChangeDeSens() {
        Partie partie =Partie.getInstance();
        if(partie.getSens()==Partie.AIGUILLE_MONTRE)
            partie.setSens(Partie.SENS_INVERSE);
        else
            partie.setSens(Partie.AIGUILLE_MONTRE);
    }

    @Override
    public void effet() {
        ChangeDeSens();
    }

    //EQUALS + TO STRING
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteReverse that = (CarteReverse) o;
        return super.getCouleur()==that.getCouleur();
    }

    @Override
    public String toString() {
        return "carte_Change_"+super.getCouleur()+".png";
    }
}
