import java.io.FileNotFoundException;
import java.util.*;

public class BullShitGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> text = Reader.readToArray("borbala.txt");
//        System.out.println(Reader.wordsHashMap.keySet().size());
//        System.out.println(SemAnalizer.findMaxWords(Reader.wordsHashMap));
        BullShitGenerator main = new BullShitGenerator();
//        System.out.println(main.bullshitGenerator(text));
    }

    public String bullshitGenerator(ArrayList<String> words) {
        Random rndmzr = new Random();
        StringBuilder text = new StringBuilder();
        int dotSpot = 0;
        for (int i = 0; i < words.size(); ) {
            if (dotSpot == 0) {
                dotSpot = rndmzr.nextInt(20) + 5; //hogy néha pont is kerüljön a szövegbe + ld. lejjebb
            }
            int nr = rndmzr.nextInt(words.size());
            Set<Integer> nrsUsed = new HashSet<>();
            if (nrsUsed.contains(nr)) {
                continue;
            } else {
                String word = words.get(nr);
                if (text.length() >= word.length() && word.equals(text.substring(text.length() - word.length() - 1, text.length() - 1))) { //hogy ne legyen szóismétlés
                    continue;
                }
                if (text.length() >= word.length() && text.length() > 3 && isLastWordDefArticle_A_(text.substring(text.length() - 3, text.length())) &&
                        isLetterVowel(word.substring(0, 1))) { // 'a' névelő után ne kezdődjön szó magánhangzóval
                    continue;
                }
                if (text.length() >= word.length() && text.length() > 4 && isLastWordDefArticle_Az_(text.substring(text.length() - 4, text.length())) &&
                        isLetterConsonant(word.substring(0, 1))) { // 'az' névelő után ne kezdődjön szó mássalhangzóval
                    continue;
                }
                nrsUsed.add(nr);
                if (text.length() >= word.length() && word.equals("hogy") || word.equals("de") || word.equals("azonban")) {
                    text.replace(text.length() - 1, text.length(), ", "); // a 'hogy', 'azonban' és 'de' szavak elé vessző kerül
                }
                if (text.length() == 0 || text.length() >= 2 && text.substring(text.length() - 2, text.length()).equals(". ")) {
                    word = firstLetterToUpperCase(word); //mondat első betűje nagybetű legyen
                }
                text.append(word);
                if (dotSpot == 1) { //hogy néha pont is kerüljön a szövegbe
                    text.append(".");
                }
                int enter = rndmzr.nextInt(10);
                if (i != words.size() - 1) {        // a szöveg végén ne legyen se szóköz, se enter
//                    if (enter == 8 || enter == 9) {
//                        System.out.println((char) 13);
//                    } else {
                    text.append(" ");
//                    }
                }
                i++;
                dotSpot--;
            }
        }
        return text.toString();
    }

    //a, á, e, é, i, í, o, ó, ö, ő, u, ú, ü, ű
    public boolean isLetterVowel(String letter) {
        switch (letter) {
            case "a":
            case "A":
            case "á":
            case "Á":
            case "e":
            case "E":
            case "é":
            case "É":
            case "i":
            case "I":
            case "í":
            case "Í":
            case "o":
            case "O":
            case "ó":
            case "Ó":
            case "ö":
            case "Ö":
            case "ő":
            case "Ő":
            case "u":
            case "U":
            case "ú":
            case "Ú":
            case "ü":
            case "Ü":
            case "ű":
            case "Ű":
                return true;
            default:
                return false;
        }
    }

    public boolean isLetterConsonant(String letter) {
        switch (letter) {
            case "b":
            case "c":
            case "d":
            case "f":
            case "g":
            case "h":
            case "j":
            case "k":
            case "l":
            case "m":
            case "n":
            case "p":
            case "q":
            case "r":
            case "s":
            case "t":
            case "v":
            case "x":
            case "y":
            case "z":
                return true;
            default:
                return false;
        }
    }

    public String firstLetterToUpperCase(String word) {
        String firstLetter = word.substring(0, 1);
        if (word.length() > 1) {
            String leftover = word.substring(1, word.length());
            return firstLetter.toUpperCase() + leftover;
        } else {
            return firstLetter.toUpperCase();
        }
    }

    public boolean isLastWordDefArticle_A_(String word) {
        if (word.equals(" a ") || word.equals(" A ")) {
            return true;
        }
        return false;
    }

    public boolean isLastWordDefArticle_Az_(String word) {
        if (word.equals(" az ") || word.equals(" Az ")) {
            return true;
        }
        return false;
    }
}
