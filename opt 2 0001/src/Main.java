import java.util.Scanner;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Hingangsvereisten{
    Ingangsvereisten ingangsvereisten=new Ingangsvereisten();
    Totaalprijs totaalprijs=new Totaalprijs();
    IngangsvereistenMetTotaalprijs ingangsvereistenMetTotaalprijs=new IngangsvereistenMetTotaalprijs();
    private final Scanner scanner = new Scanner(System.in);
    int minimumleeftijd = 0;
    int aantalklant=0;
    String hvolwassenen = "";
    String hgeldiglegitimatiebewijs = "";
    boolean HVPvolwassenenteamleden=false;
    boolean HVPgeldiglegitimatiebewijs=false;

    public void ingangsvereisten() {

        while (true) {
            System.out.print("Vul a.u.b. de minimumleeftijd van uw teamleden in.  Voer het nummer in (bijv. 15) ");
            try {
                minimumleeftijd = scanner.nextInt();
                // 对name进行进一步的处理
                break;  // 如果成功获取了一个字符串，就退出循环
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid text value.");
                scanner.nextInt();  // 清空scanner中的错误输入
            }
        }

        System.out.print("Zijn er volwassenen in je team?  Vul a.u.b. woord (ja of nee) in.");
        while (!hvolwassenen.equals("ja") && !hvolwassenen.equals("no")) {
            System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
            hvolwassenen = scanner.nextLine().toLowerCase();
        }
        if(hvolwassenen.equals("ja")){ HVPvolwassenenteamleden = true;}


        System.out.print("Heeft iedereen in uw team een geldig legitimatiebewijs zoals ID-kaart, rijbewijs of paspoort. ");
        System.out.print("Vul a.u.b. woord (ja of nee) in. ");
        while (!hgeldiglegitimatiebewijs.equals("ja") && !hgeldiglegitimatiebewijs.equals("no")) {
            System.out.println("invoerfout!!! vul je a.u.b (ja of nee) in");
            hgeldiglegitimatiebewijs = scanner.nextLine().toLowerCase();
        }
        if(hgeldiglegitimatiebewijs.equals("ja")){ HVPgeldiglegitimatiebewijs = true;}


        while (true) {
            System.out.print("Vul a.u.b. de aantal teamleden van uw team in.  Voer het nummer in (bijv. 15) ");
            try {
                aantalklant = scanner.nextInt();
                // 对name进行进一步的处理
                break;  // 如果成功获取了一个字符串，就退出循环
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid text value.");
                scanner.nextInt();  // 清空scanner中的错误输入
            }
        }

    }
    public void Thngangsvereisten(){ingangsvereisten.Toegangscontrole(minimumleeftijd,HVPvolwassenenteamleden,HVPgeldiglegitimatiebewijs);}
    public void Thtotaalprijs(){
        totaalprijs.getEindPrijs(aantalklant);
    }
    public  void Thtotaalprijsmetingangvereisen(){ingangsvereistenMetTotaalprijs.getPrijs(aantalklant,HVPvolwassenenteamleden,HVPgeldiglegitimatiebewijs,minimumleeftijd);}

}
class Ingangsvereisten {
    int leeftijd= 15;
    public boolean Toegangscontrole (int minimaleLeeftijd, boolean g, boolean h) {
        return (leeftijd > minimaleLeeftijd) || g || h;
    }
}

class IngangsvereistenMetTotaalprijs {
    Totaalprijs totaalprijs=new Totaalprijs();
    private static int minimaalleeftijd = 15;
    public double getPrijs(int groepsomvang, boolean volwassenenteamleden, boolean geldiglegitimatiebewijs, int minimaalleeftijdvanteamleden) {
        double prijs = 0.0;
        if (minimaalleeftijdvanteamleden < minimaalleeftijd) {
            prijs = -1;
        } else if(minimaalleeftijdvanteamleden>= 18&&geldiglegitimatiebewijs==true){
            prijs = totaalprijs.getEindPrijs(groepsomvang);
        } else if (volwassenenteamleden == false) {
            prijs = -1;
        } else if (geldiglegitimatiebewijs==false) {
            prijs = -1;
        } else if (geldiglegitimatiebewijs==true) {
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

class IngangsvereistenTest {
    Ingangsvereisten ingangsvereisten = new Ingangsvereisten();
    @Test
    void ingangsvereistencontrole() {
        assertTrue(ingangsvereisten.Toegangscontrole(8, false,false));
        assertTrue(ingangsvereisten.Toegangscontrole(17, true,false));
        assertTrue(ingangsvereisten.Toegangscontrole(17, false,true));
        assertTrue(ingangsvereisten.Toegangscontrole(8, true,true));

        assertFalse(ingangsvereisten.Toegangscontrole(16, false,false));
    }
}
class IngangsvereistenTestMetTotaalprijs {
    IngangsvereistenMetTotaalprijs ingangsvereistenMetTotaalprijs=new IngangsvereistenMetTotaalprijs();
    @Test
    void imetp() {
        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, true, true, 12), 0.001);

        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, true, false, 15), 0.001);
        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, true, false, 17), 0.001);
        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, true, false, 21), 0.001);

        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, false, true, 15), 0.001);
        assertEquals (-1.0, ingangsvereistenMetTotaalprijs.getPrijs (2, false, true, 17), 0.001);
        assertEquals (80.0, ingangsvereistenMetTotaalprijs.getPrijs (2, false, true, 21), 0.001);

        assertEquals (180.0, ingangsvereistenMetTotaalprijs.getPrijs (5, false, true, 21), 0.001);
        assertEquals (216.0, ingangsvereistenMetTotaalprijs.getPrijs (6, false, true, 21), 0.001);
        assertEquals (320.0, ingangsvereistenMetTotaalprijs.getPrijs (10, false, true, 21), 0.001);
        assertEquals (352.0, ingangsvereistenMetTotaalprijs.getPrijs (11, false, true, 21), 0.001);
    }
}
class TotaalprijsTest {
    Totaalprijs totaalprijs=new Totaalprijs();
    @Test
    void getPrijs() {
        int aantalteamleden2 = 1;
        int aantalteamleden3 = 4;
        int aantalteamleden4 = 5;
        int aantalteamleden5 = 6;
        int aantalteamleden6 = 9;
        int aantalteamleden7 = 11;
        assertEquals (40.00, totaalprijs.getEindPrijs(aantalteamleden2), 0.001);
        assertEquals (160.00, totaalprijs.getEindPrijs(aantalteamleden3), 0.001);
        assertEquals (180.00, totaalprijs.getEindPrijs(aantalteamleden4), 0.001);
        assertEquals (216.00, totaalprijs.getEindPrijs(aantalteamleden5), 0.001);
        assertEquals (324.00, totaalprijs.getEindPrijs(aantalteamleden6), 0.001);
        assertEquals (352.00, totaalprijs.getEindPrijs(aantalteamleden7), 0.001);
    }
}
public class Main {
    public static void main(String[] args) {

        Hingangsvereisten hingangsvereisten=new Hingangsvereisten();
        hingangsvereisten.ingangsvereisten();
        hingangsvereisten.Thngangsvereisten();
        hingangsvereisten.Thtotaalprijs();
        hingangsvereisten.Thtotaalprijsmetingangvereisen();
    }
}