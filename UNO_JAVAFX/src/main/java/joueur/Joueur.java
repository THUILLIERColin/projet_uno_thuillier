package joueur;

import cartes.Carte;
import cartes.CartePlus2;
import exceptions.*;
import partie.Partie;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Définition d'un joueur
 */
public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Carte> laMain = new ArrayList<>();

    private boolean passer=false;

    /*
            DE BASES
     */

    /**
     * initialisation du joueur avec son nom
     * @param nom
     */

    public Joueur(String nom){
        setNom(nom);
        Partie.getInstance().ajouterJoueurs(this);
    }

    /**
     * initialise la variable pour savoir si le joueur passe son tour ou non
     * @param passer
     */
    public void setPasser(boolean passer) {
        this.passer = passer;
    }

    public boolean getPasser() {
        return passer;
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

    /**
     * Ajoute la carte à la main du joueur
     * @param cartes
     */
    public void initLaMain(Carte cartes){
        if(laMain.size() < 0 || laMain.size() >7)
            throw new IllegalArgumentException("Nombres de cartes non valide");
        laMain.add(cartes);
    }

    public int getTailleDeLaMain(){
        return laMain.size();
    }
    public boolean doitDireUno(){
        return laMain.size()==1;
    }

    /*
            FONCTION POUR JOUER
     */

    /**
     * Le joueur dit UNO
     * @throws JoueurException
     * @throws UnoException
     */
    public void disUNO() throws JoueurException{
        if(this != Partie.getInstance().getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        if(doitDireUno()) {
            this.uno=true;
        }
        else{
            throw new JoueurException("Le joueur "+ this +" possède plus d'une cartes",this);
        }
    }

    // FONCTION ENCAISSER 2

    /**
     * Fonction qui permet au joueur de piocher
     * @throws JoueurException
     */
    public void piocher() throws JoueurException, UnoException, VictoireException {
        Partie partie = Partie.getInstance();
        if(partie.getSiJoueurAJoue())
            throw new JoueurException("Erreur : tu as deja joue", this);
        if(this != partie.getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        if(uno) uno=false;
        if(partie.getCumulPlus2()!= 0 && !partie.getSiJoueurAJoue()){
            encaisser(); punir();
            finirTour();
        }
        else {
            laMain.add(partie.prendrePioche());
            partie.setJoueurAJoue(true);
        }
    }

    /**
     * sert a jouer la carte en parametre
     * @param carte
     * @throws JoueurException
     * @throws CartesValideException
     * @throws ExpertManquantException
     */
    public void jouer(Carte carte) throws JoueurException, CartesValideException, ExpertManquantException, UnoException, VictoireException {
        Partie partie = Partie.getInstance();

        if(this != partie.getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        if(partie.getSiJoueurAJoue())
            throw new JoueurException("Erreur ce joueur a deja joue ", this);
        if(partie.getCumulPlus2()!=0 && !(carte instanceof CartePlus2)) {
            System.out.println("On rentre dans un Cumul punition");
            encaisser();
            punir();
            finirTour();
        }
        else {
            partie.ajouterDansTas(carte);
            laMain.remove(carte);
            partie.setJoueurAJoue(true);
            partie.getPremiereCarteTas().effet();
        }
    }

    /**
     * Fonction qui permet de finir le tour
     * @throws JoueurException
     * @throws UnoException
     */
    public void finirTour() throws JoueurException,UnoException, VictoireException {
        Partie partie = Partie.getInstance();
        if(laMain.isEmpty()) throw new VictoireException(this);
        if(this != partie.getJoueurCourant()) throw new JoueurException("Ce n'est pas ton tour ", this);
        if(partie.getCumulPlus2()!=0 && !partie.getSiJoueurAJoue()) {
            encaisser();
            punir();
        }
        if(!partie.getSiJoueurAJoue()) throw new JoueurException(""+ this +" tu n'as pas encore joue ", this);
        if(doitDireUno() && !uno) throw new UnoException("Le joueur n'a pas dit UNO ", this);
        partie.Suivant();
        if (passer){
            partie.Suivant();
            passer=false;
        }
        partie.setJoueurAJoue(false);
    }

    /**
     * Fonction qui puni le joueur en lui donnant 2 carte de la pioche
     * @throws JoueurException
     * @throws UnoException
     */
    public void punir() throws JoueurException,UnoException{
        Partie partie = Partie.getInstance();
        laMain.add(partie.prendrePioche());
        laMain.add(partie.prendrePioche());
    }

    /**
     * Punition lors d'une Carte invalide jouer
     * @throws JoueurException
     * @throws UnoException
     */
    public void punirCarteValideException() throws JoueurException,UnoException{
        punir();
        Partie.getInstance().Suivant();
    }

    /**
     * Fonction lors d'un oublis de uno
     * @throws JoueurException
     * @throws UnoException
     */
    public void punirUnoException() throws JoueurException, UnoException {
        Partie partie = Partie.getInstance();
        punir();
        laMain.add(partie.getPremiereCarteTas());
        partie.removeCarteTas(partie.getPremiereCarteTas());
        partie.setCumulPlus2(0);
        partie.Suivant();
    }

    /**
     * encaisse les plus 2
     */
    public void encaisser() throws JoueurException {
        Partie partie = Partie.getInstance();
        if(this != partie.getJoueurCourant()) throw new JoueurException("Ce n'est pas ton tour ", this);
        if(partie.getPremiereCarteTas() instanceof CartePlus2 && !partie.getSiJoueurAJoue()) {
            CartePlus2 plus2 = (CartePlus2) partie.getPremiereCarteTas();
            for(int i =0; i < partie.getCumulPlus2()*2; i++){
                laMain.add(partie.prendrePioche());
            }
            partie.setCumulPlus2(0);
            partie.setJoueurAJoue(true);
        }
    }

    /*
           TO STRING
     */

    @Override
    public String toString() {
        return ""+nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return uno == joueur.uno && Objects.equals(nom, joueur.nom) && Objects.equals(laMain, joueur.laMain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, uno, laMain);
    }
}