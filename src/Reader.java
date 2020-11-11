import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
    public static HashMap<String, Integer> wordsHashMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        read("PairProject.From11.11/borbala.txt");
        System.out.println(wordsHashMap);
    }


    public static HashMap<String, Integer> read(String textName) throws FileNotFoundException {
        Set<Character> charsToIgnore= new HashSet<>();
        charsToIgnore.add('.');
        charsToIgnore.add('!');
        Scanner sc = new Scanner(new File(textName));
        
        for (int i = 0; sc.hasNext(); i++) {
            String word = sc.next();
            System.out.println(word);
            word = word.substring(0).toLowerCase();
            System.out.println(wordWithIgnores(word,charsToIgnore));
            
            wordsHashMap.putIfAbsent(word, 0);
            Integer put = wordsHashMap.get(word);
            put++;
            wordsHashMap.put(word, put);
        }return wordsHashMap;
    }



    public static String wordWithIgnores(String toPrint, Set<Character> ignore) {
       String word ="";
    for(Character c : toPrint.toCharArray()) {
            if(! ignore.contains(c)) {
               c.toString();
                word= word+c;
            }
        }return word;
    }

}

