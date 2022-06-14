package test;

import partie.Partie;

public class AllTest {
    public static void main(String[] args) {
        TestCartePasser testCartePasser= new TestCartePasser();
        TestCartePlus2 testCartePlus2= new TestCartePlus2();
        TestCarteSimple testCarteSimple= new TestCarteSimple();
        TestPunition testPunition= new TestPunition();
        TestDisUno testDisUno = new TestDisUno();
        TestCarteSimpleIllegale testCarteSimpleIllegale = new TestCarteSimpleIllegale();
        TestReverse testReverse = new TestReverse();
        TestCarteChangerCouleur testCarteChangerCouleur = new TestCarteChangerCouleur();

        System.out.println("------ TEST CARTE SIMPLE  ------");
        testCarteSimple.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST CARTE SIMPLE ILLÉGALES  ------");
        testCarteSimpleIllegale.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST PUNITION ------");
        testPunition.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST UNO  ------");
        testDisUno.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST CARTE PASSE TOUR  ------");
        testCartePasser.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST CARTE +2  ------");
        testCartePlus2.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST REVERSE  ------");
        testReverse.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n------ TEST CHANGER COULEUR  ------");
        testCarteChangerCouleur.main(args);
        System.out.println("\n\t\tTEST OK");
        Partie.getInstance().reinitialiserPartie();
    }
}
