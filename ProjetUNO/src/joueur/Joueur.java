package joueur;

import cartes.Cartes;
import partie.Partie;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Cartes> lesCartes = new ArrayList<>();

    private Partie partie = Partie.getInstance();

    public Partie getPartie() {
        return partie;
    }

    public Joueur(String nom){
        setNom(nom);

    }

    public void setNom(String nom) {
        if(nom.equals(null)|| nom.trim().equals(""))
            throw new IllegalArgumentException("Probleme de nom");
        this.nom = nom;
    }

    public String getNom() {
        return nom;
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
        lesCartes.add(cartes);
    }

    public void piocher(){
        lesCartes.add(partie.prendre());
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", uno=" + uno +
                ", lesCartes=" + lesCartes +
                ", partie=" + partie +
                '}';
    }
}