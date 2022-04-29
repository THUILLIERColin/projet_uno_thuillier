package cartes;

public class CarteSimple extends Cartes {
    private int numero;

    /*
            CONSTRUCTEUR
     */
    public CarteSimple(Color c,int numero) {
        super(c);
        setNumero(numero);
    }

    public CarteSimple(CarteSimple c){
        super(c.getCouleur());
        this.numero =c.numero;   // Pas obligé d'appeler le setter car on sait que c'est juste
    }

    /*
            SETTER
     */
    public void setNumero(int numero) {
        if(this.numero <0 || this.numero >9){
            throw new IllegalArgumentException("Numéro de carte simple incorrect il doit être entre 1 et 9");
        }
        this.numero = numero;
    }


    /*
            GETTER
     */
    public int getNumero() {
        return numero;
    }

    /*
            EQUALS + TOSTRING
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteSimple that = (CarteSimple) o;
        return numero == that.numero && super.getCouleur()==that.getCouleur();
    }

    @Override
    public String toString() {
        return "\nCarteSimple[ " +
                "Numéro= " + numero +
                "; Couleur : " +super.getCouleur()+
                ']';
    }

    @Override
    public void effet() {}
}
