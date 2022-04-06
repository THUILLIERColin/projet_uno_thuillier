package cartes;

import java.util.Objects;

public class CarteSimple extends Cartes {
    private int Numéro;

    //CONSTRUCTEUR
    public CarteSimple(Color c,int numéro) {
        super(c);
        setNuméro(numéro);
    }

    public CarteSimple(CarteSimple c){
        super(c.getCouleur());
        this.Numéro=c.Numéro;
    }

    //SETTER
    public void setNuméro(int numéro) {
        if(numéro<1 || numéro>9){
            throw new IllegalArgumentException("Numéro de carte simple incorrect il doit être entre 1 et 9");
        }
        Numéro = numéro;
    }


    //GETTER
    public int getNuméro() {
        return Numéro;
    }

    //EQUALS + TOSTRING
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteSimple that = (CarteSimple) o;
        return Numéro == that.Numéro && super.getCouleur()==that.getCouleur();
    }

    @Override
    public String toString() {
        return "CarteSimple[ " +
                "Numéro= " + Numéro +
                "Couleur : " +super.getCouleur()+
                ']';
    }
}
