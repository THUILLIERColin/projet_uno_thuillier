package cartes;

import joueur.Joueur;

public class CarteReverse extends Carte {
    @Override
    public void effet() throws Exception {

    }
    //CONSTRUCTEUR
    public CarteReverse(Color c) {
        super(c);
    }


    // PEUT-ETRE ENLEVER LE BOOL SENS ET FOURNIR A LA FONCTION LA LISTE DES JOUEURS
    public void ChangeDeSens() throws Exception {

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
        return "Reverse[ Couleur : "+super.getCouleur()+" ]";
    }
}
