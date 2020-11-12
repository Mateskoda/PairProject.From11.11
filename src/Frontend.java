import java.io.FileNotFoundException;
import java.util.Scanner;

public class Frontend {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Üdvözli a szemantikai elemző és halandzsagyártó alkalmazás!");
        String repeat = "i";
        while (!repeat.equals("n")) {
            String textChoose = "0";
            String textSource = "0";
            String taskChoose = "0";
            System.out.print("Melyik szolgáltatásunk érdekli? A szemantikai elemzés (1) vagy a halandzsagyártás (2)? ");
            String service = s.next();
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
                    System.out.println("(1) 10 (vagy kevesebb), a szövegben leggyakrabban előforduló szó.");
                    System.out.println("(2) 10 (vagy kevesebb), a szövegben leggyakrabban előforduló - Ön által meghatározott számú betűből álló - szó.");
                    System.out.println("(3) 10 (vagy kevesebb), a szövegben leggyakrabban előforduló KÉTszavas szófordulat.");
                    System.out.println("(4) 10 (vagy kevesebb), a szövegben leggyakrabban előforduló HÁROMszavas szófordulat.");
                    System.out.println("(5) 10 (vagy kevesebb), a szövegben leggyakrabban előforduló NÉGYszavas szófordulat.");
                    System.out.println("(6) A szövegben leggyakrabban előforduló 10 név (minden tulajdonnevet és keresztnevet tekintve).");
                    System.out.println("(7) A szövegben leggyakrabban előforduló 10 keresztnév.");
                    System.out.print("Melyik kimutatásra kíváncsi? ");
                    taskChoose = s.next();
                    switch (taskChoose) {
                        case "1":
                            System.out.println(SemAnalizer.findMaxWords(Reader.read(textSource)));
                            break;
                        case "2":
                            String numberOfLetters = "0";
                            while (Integer.parseInt(numberOfLetters) > 20  || Integer.parseInt(numberOfLetters) < 1) {
                                System.out.print("Hány betűből álló szavakat keressek (1-20)? ");
                                numberOfLetters = s.next();
                                if (Integer.parseInt(numberOfLetters) > 20 || Integer.parseInt(numberOfLetters) < 1) {
                                    System.out.println("0-nál nagyobb, 21-nél kisebb számot szíveskedjen megadni!");
                                } else {
                                    System.out.println(SemAnalizer.findMaxWordsWithLetterCnt(Reader.read(textSource), Integer.parseInt(numberOfLetters)));
                                }
                            }
                            break;
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
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
