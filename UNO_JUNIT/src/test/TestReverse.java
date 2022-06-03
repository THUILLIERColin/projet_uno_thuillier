package test;

import partie.Partie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestReverse {

    private static void Test1(){
        /*
            Alice joue le 2 Rouge
            Alice fini le tour
            Vérifier que Bob est bien le joueur courant
            Bob pose le « Reverse Rouge »
            Bob fini son tour
            Vérifier que Alice est le joueur courant
         */
    }

    private static void Test2(){
         /*
            Vérifier que Alice est bien le joueur courant
            Alice pose le « Reverse »
            Alice finit son tour
            Vérifier que Charles est le joueur courant
         */
    }
    public static void main(String[] args) {
        Partie partie = Partie.getInstance();

        Test1();
        partie.reinitialiserPartie();
        Test2();
    }
}
