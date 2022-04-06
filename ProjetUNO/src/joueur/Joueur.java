package joueur;

import cartes.Cartes;
import partie.Partie;

import java.util.ArrayList;

public class Joueur {
    private String Nom;
    private boolean uno=false;
    private ArrayList<Cartes> lesCartes = new ArrayList<>();

    public Joueur(String nom){

    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setUno(boolean uno) {
        this.uno = uno;
    }

    public boolean getUno() {
        return uno;
    }

    public ArrayList<Cartes> getLesCartes() {
        return lesCartes;
    }

    public void ajouterCartes(Cartes cartes){
        if(lesCartes.size() < 0 || lesCartes.size() >7)
            throw new IllegalArgumentException("Nombres de cartes non valide");
    }

    public void piocher(){
        lesCartes.add();
    }
}
