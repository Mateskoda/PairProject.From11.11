import java.io.FileNotFoundException;
import java.util.*;

public class BullShitGenerator {
    char newLine = (char) 10;


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> text = Reader.readToArray("borbala.txt");
//        System.out.println(Reader.wordsHashMap.keySet().size());
//        System.out.println(SemAnalizer.findMaxWords(Reader.wordsHashMap));
        BullShitGenerator main = new BullShitGenerator();
        System.out.println(main.bullshitGenerator(text));
    }

    public String bullshitGenerator(ArrayList<String> words) {
        Random rndmzr = new Random();
        StringBuilder text = new StringBuilder();
        int dotSpot = 0;
        boolean newRow = false;
        int hadNewRow = 2;
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
                if (text.length() > word.length() && word.equals(text.substring(text.length() - word.length() - 1, text.length() - 1))) { //hogy ne legyen szóismétlés
                    continue;
                }
                if (text.length() > 3 && isLastWordDefArticle_A_(text.substring(text.length() - 3, text.length())) &&
                        isLetterVowel(word.substring(0, 1))) { // 'a' névelő után ne kezdődjön szó magánhangzóval
                    continue;
                }
                if (text.length() > 4 && isLastWordDefArticle_Az_(text.substring(text.length() - 4, text.length())) &&
                        isLetterConsonant(word.substring(0, 1))) { // 'az' névelő után ne kezdődjön szó mássalhangzóval
                    continue;
                }
                nrsUsed.add(nr);
                if (text.length() == 0 || text.length() >= 2 && text.substring(text.length() - 2, text.length()).equals(". ") || newRow) {
                    word = firstLetterToUpperCase(word); //mondat első betűje nagybetű legyen
                }
                if (text.length() >= word.length() && wordNeedsComma(word)) {
                    text.replace(text.length() - 1, text.length(), ", "); // a felsorolt szavak elé vessző kerül
                }
                text.append(word);
                newRow = false;
                int enter = rndmzr.nextInt(9);
                if (dotSpot == 1) { //hogy néha pont is kerüljön a szövegbe
                    text.append(".");
                    if (enter == 5 && hadNewRow == 0) { // időnként legyen sortörés, de ne soronként
                        text.append(newLine);
                        newRow = true;
                    }
                }
                if (i != words.size() - 1) {  // a szöveg végén ne legyen se szóköz, se enter
                    text.append(" ");
                }
                if (i == words.size() - 1) {
                    text.append(".");
                }
                i++;
                dotSpot--;
                if (hadNewRow > 0) {
                    hadNewRow--;
                }
            }
        }
        return text.toString();
    }

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
            String leftover = word.substring(1);
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

    public boolean wordNeedsComma(String word) {
        if (word.equals("tehát") || word.equals("addig") || word.equals("amint") || word.equals("amik") || word.equals("mikor") || word.equals("melyet") || word.equals("minthogy") || word.equals("aztán") || word.equals(
                "mintha") || word.equals(
                "amely") || word.equals(
                "akkor") ||
                word.equals("majd") || word.equals("ami") || word.equals("mik") || word.equals("mit") || word.equals("mint") || word.equals("mert") || word.equals("hogy") ||
                word.equals("de") || word.equals("azonban") || word.equals("akivel") || word.equals("amit") ||
                word.equals("aki") || word.equals("hanem") || word.equals("ha") || word.equals("ahol") || word.equals("amikor") || word.equals("mely")) {
            return true;
        }
        return false;
    }
}
