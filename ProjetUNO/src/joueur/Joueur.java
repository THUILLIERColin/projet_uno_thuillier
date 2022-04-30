package joueur;

import cartes.Carte;
import exceptions.CartesValideException;
import exceptions.UnoException;
import partie.Partie;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Carte> laMain = new ArrayList<>();

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

    public ArrayList<Carte> getLaMain() {
        return laMain;
    }

    public Carte getCarte(int i){
        return laMain.get(i);
    }

    public void InitialisationCartes(Carte cartes){
        if(laMain.size() < 0 || laMain.size() >7)
            throw new IllegalArgumentException("Nombres de cartes non valide");
        laMain.add(cartes);
    }

    public int TailleDeLaMain(){
        return laMain.size();
    }
    public boolean doitDireUno(){
        return laMain.size()==1;
    }

    /*
            FONCTION POUR JOUER
     */

    public void disUNO() throws UnoException{
        if(doitDireUno())
            this.uno=true;
        else{
            throw new UnoException("Le joueur "+ this +"possède plus d'une cartes",this);
        }
    }

    public void piocher() throws Exception{
        Partie partie = Partie.getInstance();
        if(this == partie.getJoueurCourant())
            laMain.add(partie.prendre());
        throw new IllegalArgumentException("Erreur ce n'est pas son tour");
    }

    public void jouer(Carte carte) throws Exception{
        Partie partie = Partie.getInstance();
        if(this != partie.getJoueurCourant())
            throw new IllegalArgumentException("Erreur le joueur n'est pas celui qui doit jouer");
        System.out.println(""+ this+" joue le" + carte);
        partie.ajouterDansTas(carte);
        laMain.remove(carte);
        partie.Suivant();
    }

    /*
           TO STRING
     */

    @Override
    public String toString() {
        return ""+nom;
    }
}