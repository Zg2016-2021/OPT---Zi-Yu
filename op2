import java.util.Scanner;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Hingangsvereisten {
    Ingangsvereisten ingangsvereisten = new Ingangsvereisten();
    Totaalprijs totaalprijs = new Totaalprijs();
    IngangsvereistenMetTotaalprijs ingangsvereistenMetTotaalprijs = new IngangsvereistenMetTotaalprijs();
    private final Scanner scanner = new Scanner(System.in);
    int aantalklant = 0;

    String hvolwassenen = "";
    String hdeelnemersjongerdan15 = "";
    String hgeldiglegitimatiebewijs = "";
    boolean HVPdeelnemersjongerdan15 = true;
    boolean HVPvolwassenenteamleden = true;
    boolean HVPgeldiglegitimatiebewijs = true;

    public void ingangsvereisten() {

        System.out.print("Zijn er deelnemers onder de 15 jaar?");
        do {
            hdeelnemersjongerdan15 = scanner.nextLine().toLowerCase();

            if (!hdeelnemersjongerdan15.equals("ja") && !hdeelnemersjongerdan15.equals("nee")) {
                System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
            }
        } while (!hdeelnemersjongerdan15.equals("ja") && !hdeelnemersjongerdan15.equals("nee"));

        if (hdeelnemersjongerdan15.equals("ja")) {
            HVPdeelnemersjongerdan15 = false;
        }

        System.out.println("Zijn er volwassenen in je team? Vul a.u.b. ja of nee in.");
        do {
            hvolwassenen = scanner.nextLine().toLowerCase();

            if (!hvolwassenen.equals("ja") && !hvolwassenen.equals("nee")) {
                System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
            }
        } while (!hvolwassenen.equals("ja") && !hvolwassenen.equals("nee"));

        if (hvolwassenen.equals("ja")) {
            HVPvolwassenenteamleden = false;
        }


        System.out.println("Heeft iedereen in uw team een geldig legitimatiebewijs zoals ID-kaart, rijbewijs of paspoort.");
        do {
            hgeldiglegitimatiebewijs = scanner.nextLine().toLowerCase();

            if (!hgeldiglegitimatiebewijs.equals("ja") && !hgeldiglegitimatiebewijs.equals("nee")) {
                System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
            }
        } while (!hgeldiglegitimatiebewijs.equals("ja") && !hgeldiglegitimatiebewijs.equals("nee"));

        if (hgeldiglegitimatiebewijs.equals("ja")) {
            HVPgeldiglegitimatiebewijs = false;
        }


        while (true) {
            System.out.print("Vul a.u.b. de aantal teamleden van uw team in.  Voer het nummer in (bijv. 15) ");
            try {
                aantalklant = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid text value.");
                scanner.nextInt();
            }
        }
    }
    public void Thngangsvereisten() {
        boolean result = ingangsvereisten.Toegangscontrole(HVPdeelnemersjongerdan15, HVPvolwassenenteamleden, HVPgeldiglegitimatiebewijs);
        if (result) {
            System.out.println("");
            System.out.println("Voldoet niet aan deelname-eisen voor This Outdoor Ski Area.");
            if (HVPdeelnemersjongerdan15) {
                System.out.println("Deelnemers moeten voldoen aan de minimumleeftijdseis 15");
            } else if (HVPvolwassenenteamleden) {
                System.out.println("Er moet een volwassen deelnemer aanwezig zijn");
            } else if (HVPgeldiglegitimatiebewijs) {
                System.out.println("Deelnemers dienen een geldig legitimatiebewijs te kunnen tonen");
            }
        } else {
            System.out.println("SK Outdoor Ski Resort verheugt zich op uw komst.");
        }
    }
}

class Ingangsvereisten {
    public boolean Toegangscontrole (boolean s, boolean g, boolean h) {
        return s || g || h;
    }
}

class IngangsvereistenMetTotaalprijs {
    Totaalprijs totaalprijs=new Totaalprijs();
    private static final int minimaalleeftijd = 15;
    public double getPrijs(int groepsomvang, boolean volwassenenteamleden, boolean geldiglegitimatiebewijs, int minimaalleeftijdvanteamleden) {
        double prijs = 0.0;
        if (minimaalleeftijdvanteamleden < minimaalleeftijd) {
            prijs = -1;
        } else if (!volwassenenteamleden) {
            prijs = -1;
        } else if (!geldiglegitimatiebewijs) {
            prijs = -1;
        } else {
            prijs = totaalprijs.getEindPrijs(groepsomvang);
        }
        return prijs;
    }
}
class Totaalprijs {
    private double basisticketkosten=40;
    public double getEindPrijs (int aantalklanten) {
        if (aantalklanten >= 10) {return basisticketkosten * aantalklanten * 0.80 ;} else if (
                aantalklanten>=5) {return basisticketkosten * aantalklanten * 0.90;} else if (
                aantalklanten > 0) {return basisticketkosten * aantalklanten;} else {
            return 0.0;
        }
    }
}




class ticketkostenbrekenen{
        IngangsvereistenMetTotaalprijs ingangsvereistenMetTotaalprijs = new IngangsvereistenMetTotaalprijs();
        private final Scanner scanner = new Scanner(System.in);
        int aantalklant = 0;
        String hvolwassenen2 = "";
        String hgeldiglegitimatiebewijs2 = "";
        int minimumleeftijd2=0;
        boolean HVP2volwassenenteamleden = false;
        boolean HVP2geldiglegitimatiebewijs = false;

        public void baingangsvereisten() {

            while (true) {
                System.out.print("wat is minimaal leeftijd van deelnmers? ");
                try {
                    minimumleeftijd2 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid text value.");
                    scanner.nextInt();  // 清空scanner中的错误输入
                }
            }

            System.out.println("Zijn er volwassenen in je team? Vul a.u.b. ja of nee in.");
            do {
                hvolwassenen2 = scanner.nextLine().toLowerCase();

                if (!hvolwassenen2.equals("ja") && !hvolwassenen2.equals("nee")) {
                    System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
                }
            } while (!hvolwassenen2.equals("ja") && !hvolwassenen2.equals("nee"));

            if (hvolwassenen2.equals("ja")) {
                HVP2volwassenenteamleden = true;
            }


            System.out.println("Heeft ieder deelnmers in uw team een geldig legitimatiebewijs? (zoals ID-kaart, rijbewijs of paspoort.)");
            do {
                hgeldiglegitimatiebewijs2 = scanner.nextLine().toLowerCase();

                if (!hgeldiglegitimatiebewijs2.equals("ja") && !hgeldiglegitimatiebewijs2.equals("nee")) {
                    System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
                }
            } while (!hgeldiglegitimatiebewijs2.equals("ja") && !hgeldiglegitimatiebewijs2.equals("nee"));

            if (hgeldiglegitimatiebewijs2.equals("ja")) {
                HVP2geldiglegitimatiebewijs = true;
            }

            while (true) {
                System.out.print("Vul a.u.b. de aantal teamleden van uw team in.  Voer het nummer in (bijv. 15) ");
                try {
                    aantalklant = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid text value.");
                    scanner.nextInt();
                }
            }
        }
        public void HVPtickestprijs() {
            double prijs=ingangsvereistenMetTotaalprijs.getPrijs(aantalklant,HVP2volwassenenteamleden,HVP2geldiglegitimatiebewijs,minimumleeftijd2);
            System.out.println("");
            System.out.println("het totaal ticketkosten zijn:"+prijs);
            System.out.println("Let op: een resultaat van -1,0 betekent dat je niet voldoet aan één of meer van de toelatingseisen voor dit outdoorskigebied.");
        }

}


class IngangsvereistenTest {
    Ingangsvereisten ingangsvereisten = new Ingangsvereisten();
    @Test
    void ingangsvereistencontrole() {
        assertFalse(ingangsvereisten.Toegangscontrole(false, false,false));
        assertTrue(ingangsvereisten.Toegangscontrole(true, false,false));
        assertTrue(ingangsvereisten.Toegangscontrole(false, true,false));
        assertTrue(ingangsvereisten.Toegangscontrole(false, false,true));
        assertTrue(ingangsvereisten.Toegangscontrole(true, true,true));

    }
}
class IngangsvereistenTestMetTotaalprijs {
    IngangsvereistenMetTotaalprijs ingangsvereistenMetTotaalprijs=new IngangsvereistenMetTotaalprijs();
    @Test
    void imetp() {
        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (1, true, true, 12), 0.001);
        assertEquals (40.00, ingangsvereistenMetTotaalprijs.getPrijs (1, true, true, 15), 0.001);

        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (6, true, false, 15), 0.001);
        assertEquals ((36*6), ingangsvereistenMetTotaalprijs.getPrijs (6, true, true, 15), 0.001);


        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (11, false, true, 15), 0.001);
        assertEquals ((11*32), ingangsvereistenMetTotaalprijs.getPrijs (11, true, true, 15), 0.001);
    }
}
class TotaalprijsTest {
    Totaalprijs totaalprijs=new Totaalprijs();
    @Test
    void getPrijs() {
        int aantalteamleden0 = 0;
        int aantalteamleden1 = 1;
        int aantalteamleden4 = 4;
        int aantalteamleden5 = 5;
        int aantalteamleden6 = 6;
        int aantalteamleden9 = 9;
        int aantalteamleden10 = 10;
        int aantalteamleden11 = 11;
        assertEquals (0.00, totaalprijs.getEindPrijs(aantalteamleden0), 0.001);
        assertEquals (40.00, totaalprijs.getEindPrijs(aantalteamleden1), 0.001);
        assertEquals (160.00, totaalprijs.getEindPrijs(aantalteamleden4), 0.001);
        assertEquals (180.00, totaalprijs.getEindPrijs(aantalteamleden5), 0.001);
        assertEquals (216.00, totaalprijs.getEindPrijs(aantalteamleden6), 0.001);
        assertEquals (324.00, totaalprijs.getEindPrijs(aantalteamleden9), 0.001);
        assertEquals (320.00, totaalprijs.getEindPrijs(aantalteamleden10), 0.001);
        assertEquals (352.00, totaalprijs.getEindPrijs(aantalteamleden11), 0.001);
    }
}
public class Main {
    public static void main(String[] args) {

        Hingangsvereisten hingangsvereisten=new Hingangsvereisten();
        hingangsvereisten.ingangsvereisten();
        hingangsvereisten.Thngangsvereisten();//ingangeisen bepalen
        
        ticketkostenbrekenen ticketkostenbrekenen=new ticketkostenbrekenen();
        ticketkostenbrekenen.baingangsvereisten();
        ticketkostenbrekenen.HVPtickestprijs();//ticket berekenen

    }
}
