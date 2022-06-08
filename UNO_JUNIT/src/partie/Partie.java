package partie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import cartes.Carte;
import exceptions.CartesValideException;
import exceptions.ExpertManquantException;
import expert.Expert;
import joueur.Joueur;

/**
 * Définition d'une partie
 */
public class Partie {

    public final static boolean AIGUILLE_MONTRE = true;
    public final static boolean SENS_INVERSE = false;

    private Expert expert;

    private int NbJoueurs;
    private boolean sens=AIGUILLE_MONTRE;
    private ArrayList<Joueur> lesJoueurs = new ArrayList<Joueur>();
    private ArrayList<Carte> leTas = new ArrayList<Carte>();
    private ArrayList<Carte> laPioche = new ArrayList<Carte>();
    private ArrayList<Carte> listeCartesInitiales = new ArrayList<>();

    private static volatile Partie instance= null;

    private int cumulPlus2=0;

    private Joueur joueurCourant;
    private boolean JoueurAJoue=false;



    private Partie() {}

    /**
     * Renvoie l'instance de la partie
     * @return instance de la partie
     */
    public static Partie getInstance() {
        if (instance == null) {
            instance = new Partie();
        }
        return instance;
    }

    /*
            DE BASE
     */

    /**
     * set le cumulPlus2
     * @param cumulPlus2 le cumul de +2
     */
    public void setCumulPlus2(int cumulPlus2) {
        this.cumulPlus2 = cumulPlus2;
    }

    /**
     * renvoie le cumul de plus2
     * @return int cumul+2
     */
    public int getCumulPlus2() {
        return cumulPlus2;
    }

    /**
     * Configure le sens de jeux
     * @param sens sens de jeux
     */
    public void setSens(boolean sens) {
        this.sens = sens;
    }

    /**
     * renvoie le sens en cour de la partie
     * @return sens
     */
    public boolean getSens() {
        return sens;
    }

    /**
     * Renvoie le nombre de joueur
     * @return nombre de joueur
     */
    public int getNbJoueurs() {
        return NbJoueurs;
    }

    /**
     *
     * @param expert expert utiliser
     */
    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    /**
     *
     * @return expert
     */
    public Expert getExpert() {
        return expert;
    }

    /**
     *
     * @param joueurCourant joueur qui est en train de jouer
     */
    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    /**
     *
     * @return joueur courant
     */
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }


    /*
            POUR LES JOUEURS
     */

    /**
     * @return lesJoueurs
     */
    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    /**
     * @return nombre de joueurs
     */
    public int getTaille(){
        return lesJoueurs.size();
    }

    /**
     * renvoie un certain joueur
     * @param i position du joueur dans la liste Joueur
     * @return joueur souhaité
     */
    public Joueur getJoueur(int i){
        if(i<0)
            return lesJoueurs.get(lesJoueurs.size()+i);  // A verifier car peut-etre ajouter 1
        return lesJoueurs.get(i);
    }

    /**
     * Ajoute un joueur dans la liste de joueur
     * @param joueur
     */
    public void ajouterJoueurs(Joueur joueur){
        if(lesJoueurs.size()< 0 || lesJoueurs.size()>4)
            throw new IllegalArgumentException("NbJoueurs trop élevée");
        if(lesJoueurs.contains(joueur))
            throw new IllegalArgumentException("La liste contient deja le joueur");
        if(lesJoueurs.size()==0)
            setJoueurCourant(joueur);
        lesJoueurs.add(joueur);
        NbJoueurs = lesJoueurs.size();
    }

    /**
     *  Supprime le joueur de la liste de joueur
     * @param joueur
     */
    public void removeJoueur(Joueur joueur){
        if(!lesJoueurs.contains(joueur))
            throw new IllegalArgumentException("Joueur non trouvé");
        lesJoueurs.remove(joueur);
        NbJoueurs = lesJoueurs.size();
    }

    /**
     * renvoie l'indice d'un joueur
     * @param joueurEnJeu joueur dont on souhaite avoir l'indice
     * @return indice du joueur
     */
    public int getIndiceJoueur(Joueur joueurEnJeu){
        return lesJoueurs.indexOf(joueurEnJeu);
    }

    /*
            POUR LES CARTES DE PIOCHE
     */

    /**
     * Sert à piocher,
     * Retourne la premiere carte de la pioche
     * @return carte
     */
    public Carte prendrePioche(){
        if(laPioche.isEmpty()){
            refairePioche();
        }
        Carte cartesPioche= laPioche.get(0);
        laPioche.remove(cartesPioche);
        return cartesPioche;
    }

    /**
     * Quand la pioche se vide on prend les cartes en dessous du tas et on les mélange
     */
    public void refairePioche(){
        for (int i=1; i < leTas.size(); i++){
            laPioche.add(leTas.get(i));
            leTas.remove(i);
        }
        Collections.shuffle(laPioche);
    }

    public ArrayList<Carte> getLaPioche() {
        return laPioche;
    }

    public Carte getPremiereCartePioche(){
        return laPioche.get(0);
    }

    /*
            POUR LES CARTES DU TAS
     */

    public ArrayList<Carte> getLeTas() {
        return leTas;
    }

    public Carte getPremiereCarteTas(){
        return leTas.get(leTas.size()-1);
    }

    public void ajouterDansTas(Carte carte) throws CartesValideException, ExpertManquantException {
        if(!expert.traiter(carte))
            throw new CartesValideException("Cout invalide, la carte "+ carte +" ne peut pas etre pose sur " + getPremiereCarteTas() , joueurCourant, carte);
        leTas.add(carte);
    }

    public int getTailleTas(){
        return leTas.size();
    }

    public void removeCarteTas(Carte carte){
        leTas.remove(carte);
    }

    /*
            FONCTION DE LISTE POUR L'INITIALISATION
     */

    public ArrayList<Carte> getListeCartesInitiales() {
        return listeCartesInitiales;
    }

    public Carte getCartesDansListeCartesInitiales(int i){
        return listeCartesInitiales.get(i);
    }

    public void ajouterListeCartesInitiales(Carte cartes){
        listeCartesInitiales.add(cartes);
    }

    public void removePremiereCarteTasInitiale(){
        listeCartesInitiales.remove(0);
    }


    /*
            FONCTION POUR JOUER
     */

    /**
     * Sert à passer au joueur Suivant
     */

    public void Suivant(){
        if(getIndiceJoueur(joueurCourant) == lesJoueurs.size()-1){
            if(sens==SENS_INVERSE){
                joueurCourant= lesJoueurs.get(getIndiceJoueur(joueurCourant)-1);
            }
            else
            {
                joueurCourant= lesJoueurs.get(0);
            }
        }
        else{
            if(sens==SENS_INVERSE){
                if(getIndiceJoueur(joueurCourant) == 0)
                    joueurCourant= lesJoueurs.get(lesJoueurs.size());
                else
                    joueurCourant= lesJoueurs.get(getIndiceJoueur(joueurCourant)-1);
            }
            else
            {
                joueurCourant= lesJoueurs.get(getIndiceJoueur(joueurCourant)+1);
            }
        }
    }

    public void setJoueurAJoue(boolean joueurAJoue) {
        JoueurAJoue = joueurAJoue;
    }

    public boolean getSiJoueurAJoue() {
        return JoueurAJoue;
    }

    /*
            FAIRE FONCTION DISTRIBUER
     */

    /**
     * Sert à distribuer les cartes, elle est appelée uniquement dans initialisationPartie
     * @param nbCartesJoueur
     */

    public void distribuerCartes(int nbCartesJoueur){
        for(int i=0; i< nbCartesJoueur; i++){
            for(int j=0; j<lesJoueurs.size(); j++) {
                lesJoueurs.get(j).initLaMain(listeCartesInitiales.get(0));
                removePremiereCarteTasInitiale();
            }
        }
        leTas.add(listeCartesInitiales.get(0));
        removePremiereCarteTasInitiale();

        laPioche = listeCartesInitiales;
    }

    /*
            FONCTION D'INITIALISATION
     */
    /**
     * Fonction qui initialise la partie, le parametre sert à distribuer les cartes
     * @param nbCartesParJoueur
     */
    public void initialisationPartie(int nbCartesParJoueur){
        distribuerCartes(nbCartesParJoueur);
        joueurCourant=lesJoueurs.get(0);
    }

    /**
     * Fonction qui réinitialise la Partie
     */
    public void reinitialiserPartie(){
        instance= new Partie();
    }

    /*
           FONCTIONS GÉNÉRÉES
     */

    @Override
    public String toString() {
        return "Partie{" +
                "expert=" + expert +
                ", NbJoueurs=" + NbJoueurs +
                ", sens=" + sens +
                ", lesJoueurs=" + lesJoueurs +
                ", leTas=" + leTas +
                ", laPioche=" + laPioche +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partie partie = (Partie) o;
        return NbJoueurs == partie.NbJoueurs && sens == partie.sens && Objects.equals(expert, partie.expert) && Objects.equals(lesJoueurs, partie.lesJoueurs) && Objects.equals(leTas, partie.leTas) && Objects.equals(laPioche, partie.laPioche);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expert, NbJoueurs, sens, lesJoueurs, leTas, laPioche);
    }
}
