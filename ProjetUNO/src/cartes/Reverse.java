package cartes;

import exceptions.CartesValideException;
import joueur.Joueur;
import partie.Partie;

public class Reverse extends Cartes{
    @Override
    public void effet() throws Exception {

    }
    //CONSTRUCTEUR
    public Reverse(Color c) {
        super(c);
    }

    public Reverse(Reverse r){
        super(r.getCouleur());
    }

    //EQUALS + TO STRING
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

    // PEUT-ETRE ENLEVER LE BOOL SENS ET FOURNIR A LA FONCTION LA LISTE DES JOUEURS
    /*public void ChangeDeSens(Joueur j) throws Exception {
        if(j.getPartie().getExpert().traiter(this))
        {
            if(j.getPartie().getSens() == Partie.SENS_INVERSE){
                j.getPartie().setSens(Partie.AIGUILLE_MONTRE) ;
            }
            else
                j.getPartie().setSens(Partie.SENS_INVERSE) ;
        }
        else
            throw new CartesValideException("Impossible de changer de sens le coup n'est pas valide",this);
    }
    */
}
