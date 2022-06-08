package application;

import cartes.*;
import partie.*;

import java.util.ArrayList;
import java.util.Collections;

public class GestionCartes {
    static void melangerCarte(ArrayList<Carte> cartesInitiales) {
        if (cartesInitiales.isEmpty()) throw new IllegalArgumentException("La liste initiale ne doit pas être null");

        Collections.shuffle(cartesInitiales);
    }

    static void distribuerAuxJoueurs(int nbCartesParJoueurs) {
        Partie.getInstance().distribuerCartes(nbCartesParJoueurs);
    }

    static void creerListeCarteInitial(CreationCartes lesCartes){
        ArrayList<Carte> carte = lesCartes.getCartes();
        for (int i=0; i < carte.size(); i++){
            Partie.getInstance().ajouterListeCartesInitiales(carte.get(i));
        }
    }
}

