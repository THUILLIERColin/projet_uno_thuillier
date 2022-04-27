package joueur;

import cartes.Cartes;
import partie.Partie;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Cartes> laMain = new ArrayList<>();

    private Partie partie = Partie.getInstance();

    public Partie getPartie() {
        return partie;
    }

    /*
            DE BASES
     */

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

    /*
            POUR LaMain
     */

    public ArrayList<Cartes> getLaMain() {
        return laMain;
    }

    public Cartes getCarte(int i){
        return laMain.get(i);
    }

    public void InitialisationCartes(Cartes cartes){
        if(laMain.size() < 0 || laMain.size() >7)
            throw new IllegalArgumentException("Nombres de cartes non valide");
        laMain.add(cartes);
    }

    /*
            FONCTION POUR JOUER
     */

    public void disUNO(){
        this.uno=true;
    }

    public void piocher(){
        laMain.add(partie.prendre());
    }

    /*
           TO STRING
     */

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", uno=" + uno +
                ", lesCartes=" + laMain +
                ", partie=" + partie +
                '}';
    }
}