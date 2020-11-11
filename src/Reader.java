import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
    public static HashMap<String, Integer> wordsHashMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
//        read("borbala.txt");
//        System.out.println(wordsHashMap);
//        System.out.println(readToArray("borbala.txt"));
        ArrayList<String> text = Reader.readToArray("borbala.txt");
//        System.out.println(Reader.wordsHashMap.keySet().size());
//        System.out.println(SemAnalizer.findMaxWords(Reader.wordsHashMap));
        BullShitGenerator main = new BullShitGenerator();
        System.out.println(main.bullshitGenerator(text));
    }

    public static ArrayList<String> readToArray(String textName) throws FileNotFoundException {
        ArrayList<String> arrayListOfWords = new ArrayList<>();
        Set<Character> charsToIgnore = new HashSet<>();
        for (int i = 33; i < 64; i++) {

            charsToIgnore.add((char) i);
        }
        Scanner sc = new Scanner(new File(textName));

        for (int i = 0; sc.hasNext(); i++) {
            String word = sc.next();
            word = word.substring(0).toLowerCase();
            word = wordWithIgnores(word, charsToIgnore);
            arrayListOfWords.add(word);

        }
        return arrayListOfWords;
    }

    public static HashMap<String, Integer> read(String textName) throws FileNotFoundException {
        Set<Character> charsToIgnore = new HashSet<>();
        for (int i = 33; i < 64; i++) {

            charsToIgnore.add((char) i);
        }
        Scanner sc = new Scanner(new File(textName));

        for (int i = 0; sc.hasNext(); i++) {
            String word = sc.next();
//            System.out.println(word);

            word = word.substring(0).toLowerCase();
//            System.out.println(wordWithIgnores(word,charsToIgnore));

            word = wordWithIgnores(word, charsToIgnore);
            if (word.equals("")) {

            } else {
                wordsHashMap.putIfAbsent(word, 0);
                Integer put = wordsHashMap.get(word);
                put++;
                wordsHashMap.put(word, put);
            }
        }
        return wordsHashMap;
    }

    public static HashMap<String, Integer> read2Words(String textName) throws FileNotFoundException {
        Set<Character> charsToIgnore = new HashSet<>();
        for (int i = 33; i < 64; i++) {

            charsToIgnore.add((char) i);
        }
        Scanner sc = new Scanner(new File(textName));
        String word2 = sc.next();
        for (int i = 0; sc.hasNext(); i++) {
            String word = word2;
//            System.out.println(word);
            word2 = sc.next();
            word = word.substring(0).toLowerCase();
            word2 = word2.substring(0).toLowerCase();

//            System.out.println(wordWithIgnores(word,charsToIgnore));

            word = wordWithIgnores(word, charsToIgnore);
            word2 = wordWithIgnores(word2, charsToIgnore);
            word = word + " " + word2;
            wordsHashMap.putIfAbsent(word, 0);
            Integer put = wordsHashMap.get(word);
            put++;
            wordsHashMap.put(word, put);
        }
        return wordsHashMap;
    }


    public static String wordWithIgnores(String toPrint, Set<Character> ignore) {
        String word = "";
        for (Character c : toPrint.toCharArray()) {
            if (!ignore.contains(c)) {
                c.toString();
                word = word + c;
            }
        }
        return word;
    }

}
