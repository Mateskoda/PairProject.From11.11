import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Frontend {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Üdvözli a szemantikai elemző és halandzsagyártó alkalmazás!");
        String service = "0";
        String textChoose = "0";
        String textSource = "0";
        String taskChoose = "0";
        String repeat = "i";
        while (!repeat.equals("n")) {
            System.out.print("Melyik szolgáltatásunk érdekli? A szemantikai elemzés (1) vagy a halandzsagyártás (2)? ");
            service = s.next();
            if (!service.equals("1") && !service.equals("2")) {
                System.out.print("A felkínált lehetőségek (1 vagy 2) közül szíveskedjen választani!");
            } else if (service.equals("1")) {
                while (!textChoose.equals("1") && !textChoose.equals("2")) {
                    System.out.print("A szemantikai elemzéshez Ön ad meg referencia-szöveget (1) vagy használjam a beépített referencia-szöveget (2)? ");
                    textChoose = s.next();
                    if (!textChoose.equals("1") && !textChoose.equals("2")) {
                        System.out.print("A felkínált lehetőségek (1 vagy 2) közül szíveskedjen választani!");
                    } else if (textChoose.equals("1")) {
                        System.out.print("Szíveskedjen megadni a forrásszöveg elérési útját: ");
                        textSource = s.next();
                    } else {
                        System.out.println("A szemantikai elemzéshez a beépített referencia-szöveget fogom használni.");
                        textSource = "borbala.txt";
                    }
                }
                while (!taskChoose.equals("1") && !taskChoose.equals("2") && !taskChoose.equals("3") && !taskChoose.equals("4") && !taskChoose.equals("5") && !taskChoose.equals(
                        "6")) {
                    System.out.println("Az alábbi kimutatások elkészítésére vagyok képes:");
                    System.out.println("(1) A szövegben leggyakrabban előforduló 10 - Ön által meghatározott számú betűből álló - szó.");
                    System.out.println("(2) 10, a szövegben leggyakrabban előforduló KÉTszavas szófordulat.");
                    System.out.println("(3) 10, a szövegben leggyakrabban előforduló HÁROMszavas szófordulat.");
                    System.out.println("(4) 10, a szövegben leggyakrabban előforduló NÉGYszavas szófordulat.");
                    System.out.println("(5) A szövegben leggyakrabban előforduló 10 név (minden tulajdonnevet és keresztnevet tekintve).");
                    System.out.println("(6) A szövegben leggyakrabban előforduló 10 keresztnév.");
                    System.out.print("Melyik kimutatásra kíváncsi? ");
                    taskChoose = s.next();
                    switch (taskChoose) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        default:
                            System.out.println("A felkínált lehetőségek (1, 2, 3, 4, 5 vagy 6) közül szíveskedjen választani!");
                    }
                }
            } else {
                System.out.print("Szíveskedjen megadni a forrásszöveg elérési útját: ");
                textSource = s.next();
                BullShitGenerator bull = new BullShitGenerator();
                System.out.println(bull.bullshitGenerator(Reader.readToArray(textSource)));
            }
            System.out.print("Szeretné újra igénybe venni a szolgáltatásainkat? (i) vagy (n) ");
            repeat = s.next();
        }
    }
}
