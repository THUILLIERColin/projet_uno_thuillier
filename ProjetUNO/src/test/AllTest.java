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

        System.out.println("\t------ TEST CARTE SIMPLE  ------");
        testCarteSimple.main(args);
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n\t------ TEST CARTE SIMPLE ILLÉGALES  ------");
        testCarteSimpleIllegale.main(args);
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n\t------ TEST PUNITION ------");
        testPunition.main(args);
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n\t------ TEST UNO  ------");
        testDisUno.main(args);
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n\t------ TEST CARTE PASSE TOUR  ------");
        testCartePasser.main(args);
        Partie.getInstance().reinitialiserPartie();

        System.out.println("\n\n\t------ TEST CARTE +2  ------");
        testCartePlus2.main(args);
    }
}
