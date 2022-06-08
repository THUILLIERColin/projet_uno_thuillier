package application;

import cartes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CreationCartes{
    private ArrayList<Carte> cartes = new ArrayList<>();

    private Carte bleu0 = new CarteSimple(Carte.Color.BLEU, 0);
    private Carte bleu1 = new CarteSimple(Carte.Color.BLEU, 1);
    private Carte bleu2 = new CarteSimple(Carte.Color.BLEU, 2);
    private Carte bleu3 = new CarteSimple(Carte.Color.BLEU, 3);
    private Carte bleu4 = new CarteSimple(Carte.Color.BLEU, 4);
    private Carte bleu5 = new CarteSimple(Carte.Color.BLEU, 5);
    private Carte bleu6 = new CarteSimple(Carte.Color.BLEU, 6);
    private Carte bleu7 = new CarteSimple(Carte.Color.BLEU, 7);
    private Carte bleu8 = new CarteSimple(Carte.Color.BLEU, 8);
    private Carte bleu9 = new CarteSimple(Carte.Color.BLEU, 9);
    private Carte bleuPasse = new CartePasser(Carte.Color.BLEU);
    private Carte bleuPlus2 = new CartePlus2(Carte.Color.BLEU);

    private Carte jaune0 = new CarteSimple(Carte.Color.JAUNE, 0);
    private Carte jaune1 = new CarteSimple(Carte.Color.JAUNE, 1);
    private Carte jaune2 = new CarteSimple(Carte.Color.JAUNE, 2);
    private Carte jaune3 = new CarteSimple(Carte.Color.JAUNE, 3);
    private Carte jaune4 = new CarteSimple(Carte.Color.JAUNE, 4);
    private Carte jaune5 = new CarteSimple(Carte.Color.JAUNE, 5);
    private Carte jaune6 = new CarteSimple(Carte.Color.JAUNE, 6);
    private Carte jaune7 = new CarteSimple(Carte.Color.JAUNE, 7);
    private Carte jaune8 = new CarteSimple(Carte.Color.JAUNE, 8);
    private Carte jaune9 = new CarteSimple(Carte.Color.JAUNE, 9);
    private Carte jaunePasse = new CartePasser(Carte.Color.JAUNE);
    private Carte jaunePlus2 = new CartePlus2(Carte.Color.JAUNE);

    private Carte rouge0 = new CarteSimple(Carte.Color.ROUGE, 0);
    private Carte rouge1 = new CarteSimple(Carte.Color.ROUGE, 1);
    private Carte rouge2 = new CarteSimple(Carte.Color.ROUGE, 2);
    private Carte rouge3 = new CarteSimple(Carte.Color.ROUGE, 3);
    private Carte rouge4 = new CarteSimple(Carte.Color.ROUGE, 4);
    private Carte rouge5 = new CarteSimple(Carte.Color.ROUGE, 5);
    private Carte rouge6 = new CarteSimple(Carte.Color.ROUGE, 6);
    private Carte rouge7 = new CarteSimple(Carte.Color.ROUGE, 7);
    private Carte rouge8 = new CarteSimple(Carte.Color.ROUGE, 8);
    private Carte rouge9 = new CarteSimple(Carte.Color.ROUGE, 9);
    private Carte rougePasse = new CartePasser(Carte.Color.ROUGE);
    private Carte rougePlus2 = new CartePlus2(Carte.Color.ROUGE);

    private Carte vert0 = new CarteSimple(Carte.Color.VERT, 0);
    private Carte vert1 = new CarteSimple(Carte.Color.VERT, 1);
    private Carte vert2 = new CarteSimple(Carte.Color.VERT, 2);
    private Carte vert3 = new CarteSimple(Carte.Color.VERT, 3);
    private Carte vert4 = new CarteSimple(Carte.Color.VERT, 4);
    private Carte vert5 = new CarteSimple(Carte.Color.VERT, 5);
    private Carte vert6 = new CarteSimple(Carte.Color.VERT, 6);
    private Carte vert7 = new CarteSimple(Carte.Color.VERT, 7);
    private Carte vert8 = new CarteSimple(Carte.Color.VERT, 8);
    private Carte vert9 = new CarteSimple(Carte.Color.VERT, 9);
    private Carte vertPasse = new CartePasser(Carte.Color.VERT);
    private Carte vertPlus2 = new CartePlus2(Carte.Color.VERT);

    public CreationCartes() {
        cartes.add(bleu0);
        cartes.add(bleu1);
        cartes.add(bleu2);
        cartes.add(bleu3);
        cartes.add(bleu4);
        cartes.add(bleu5);
        cartes.add(bleu6);
        cartes.add(bleu7);
        cartes.add(bleu8);
        cartes.add(bleu9);
        cartes.add(bleuPasse);
        cartes.add(bleuPlus2);

        cartes.add(jaune0);
        cartes.add(jaune1);
        cartes.add(jaune2);
        cartes.add(jaune3);
        cartes.add(jaune4);
        cartes.add(jaune5);
        cartes.add(jaune6);
        cartes.add(jaune7);
        cartes.add(jaune8);
        cartes.add(jaune9);
        cartes.add(jaunePasse);
        cartes.add(jaunePlus2);

        cartes.add(rouge0);
        cartes.add(rouge1);
        cartes.add(rouge2);
        cartes.add(rouge3);
        cartes.add(rouge4);
        cartes.add(rouge5);
        cartes.add(rouge6);
        cartes.add(rouge7);
        cartes.add(rouge8);
        cartes.add(rouge9);
        cartes.add(rougePasse);
        cartes.add(rougePlus2);

        cartes.add(vert0);
        cartes.add(vert1);
        cartes.add(vert2);
        cartes.add(vert3);
        cartes.add(vert4);
        cartes.add(vert5);
        cartes.add(vert6);
        cartes.add(vert7);
        cartes.add(vert8);
        cartes.add(vert9);
        cartes.add(vertPasse);
        cartes.add(vertPlus2);
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public Carte getBleu0() {
        return bleu0;
    }

    public Carte getBleu1() {
        return bleu1;
    }

    public Carte getBleu2() {
        return bleu2;
    }

    public Carte getBleu3() {
        return bleu3;
    }

    public Carte getBleu4() {
        return bleu4;
    }

    public Carte getBleu5() {
        return bleu5;
    }

    public Carte getBleu6() {
        return bleu6;
    }

    public Carte getBleu7() {
        return bleu7;
    }

    public Carte getBleu8() {
        return bleu8;
    }

    public Carte getBleu9() {
        return bleu9;
    }

    public Carte getJaune0() {
        return jaune0;
    }

    public Carte getJaune1() {
        return jaune1;
    }

    public Carte getJaune2() {
        return jaune2;
    }

    public Carte getJaune3() {
        return jaune3;
    }

    public Carte getJaune4() {
        return jaune4;
    }

    public Carte getJaune5() {
        return jaune5;
    }

    public Carte getJaune6() {
        return jaune6;
    }

    public Carte getJaune7() {
        return jaune7;
    }

    public Carte getJaune8() {
        return jaune8;
    }

    public Carte getJaune9() {
        return jaune9;
    }

    public Carte getRouge0() {
        return rouge0;
    }

    public Carte getRouge1() {
        return rouge1;
    }

    public Carte getRouge2() {
        return rouge2;
    }

    public Carte getRouge3() {
        return rouge3;
    }

    public Carte getRouge4() {
        return rouge4;
    }

    public Carte getRouge5() {
        return rouge5;
    }

    public Carte getRouge6() {
        return rouge6;
    }

    public Carte getRouge7() {
        return rouge7;
    }

    public Carte getRouge8() {
        return rouge8;
    }

    public Carte getRouge9() {
        return rouge9;
    }

    public Carte getVert0() {
        return vert0;
    }

    public Carte getVert1() {
        return vert1;
    }

    public Carte getVert2() {
        return vert2;
    }

    public Carte getVert3() {
        return vert3;
    }

    public Carte getVert4() {
        return vert4;
    }

    public Carte getVert5() {
        return vert5;
    }

    public Carte getVert6() {
        return vert6;
    }

    public Carte getVert7() {
        return vert7;
    }

    public Carte getVert8() {
        return vert8;
    }

    public Carte getVert9() {
        return vert9;
    }

}

