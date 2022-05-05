package cartes;

public class CarteReverse extends Carte {
    @Override
    public void effet() throws Exception {

    }
    //CONSTRUCTEUR
    public CarteReverse(Color c) {
        super(c);
    }

    public CarteReverse(CarteReverse r){
        super(r.getCouleur());
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
