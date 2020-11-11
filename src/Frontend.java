import java.util.Scanner;

public class Frontend {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Üdvözli a szemantikai elemző és halandzsagyártó alkalmazás!");
        String service = "0";
        String textChoose = "0";
        String textSource = "0";
        while (!service.equals("1") && !service.equals("2")) {
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
                    }
                }
            } else {
                System.out.print("Szíveskedjen megadni a forrásszöveg elérési útját: ");
                textSource = s.next();
            }
        }
    }
}
