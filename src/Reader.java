import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
    public static HashMap<String, Integer> wordsHashMap = new HashMap<>();
    public static HashMap<String, Integer> wordsHashMap2Words = new HashMap<>();
    public static HashMap<String, Integer> wordsHashMapOfNames = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
//        read("borbala.txt");
//        System.out.println(wordsHashMap);
//        System.out.println(readToArray("borbala.txt"));
        ArrayList<String> text = Reader.readToArray("borbala.txt");
//        System.out.println(Reader.wordsHashMap.keySet().size());
//        System.out.println(SemAnalizer.findMaxWords(Reader.wordsHashMap));
//        BullShitGenerator main = new BullShitGenerator();
//        System.out.println(main.bullshitGenerator(text));
//        System.out.println(readNames("borbala.txt"));
        System.out.println(readHunFirstNames());
    }
public static ArrayList<String> readHunFirstNames() throws FileNotFoundException {
Scanner sc = new Scanner(new File("osszesffi.txt"));
Scanner sc2 = new Scanner(new File("osszesnoi.txt"));
ArrayList< String> names = new ArrayList<>();
    for (int i = 0; i<0 ; i++) {
        String name = sc.next();
        names.add(name);
        System.out.println(name);
    }

    for (int i = 0; sc2.hasNextLine() ; i++) {
        names.add(sc2.nextLine());
        System.out.println(sc2.nextLine());
    }return names;
    }
//    public static HashMap<String, Integer> readNames (String textName) throws FileNotFoundException {
//      Set<Character> sentenceEndingCharsToIgnore = new HashSet<>();
//      Set<Character> charsToIgnore = new HashSet<>();
//          sentenceEndingCharsToIgnore.add(('.'));
//          sentenceEndingCharsToIgnore.add(('?'));
//          sentenceEndingCharsToIgnore.add(('!'));
//          sentenceEndingCharsToIgnore.add(('-'));
//
//        for (int i = 33; i < 64; i++) {
//
//            charsToIgnore.add((char) i);
//        }
//      Scanner sc = new Scanner(new File(textName));
//
//
//          String word2 = sc.next();
//          for (int i = 0; sc.hasNext(); i++) {
//              String word = word2;
//              word2 = sc.next();
//              String wordSmallLetters = word.substring(0).toLowerCase();
//              String wordWithIgnoresString = wordWithIgnores(word, charsToIgnore);
//              if (!wordSmallLetters.equals(word)){
//                  wordsHashMapOfNames.putIfAbsent(wordWithIgnoresString, 0);
////                  Integer put = wordsHashMap.get(word);
////                  put++;
////                  wordsHashMap.put(word, put);
//              }
//              word2 = word2.substring(0).toLowerCase();
//               char dots= word.toCharArray()[word.toCharArray().length-1];
//              if (sentenceEndingCharsToIgnore.contains(dots)){
//
//                  dots= word2.toCharArray()[0];
////                  if (charsToIgnore.contains(dots)){
////                      word2 = sc.next();}dots= word2.toCharArray()[0];
////                  if (charsToIgnore.contains(dots)){
////                      word2 = sc.next();}dots= word2.toCharArray()[0];
////                  if (charsToIgnore.contains(dots)){
////                      word2 = sc.next();}
//                  if (sc.hasNext()){
//                word2 = sc.next();}
//                      if (sc.hasNext()) {
//                          word2 = sc.next();}
//                      }
//              while ( word2.toCharArray()[0]==(char)10){
//                  word2=sc.next();
//                  word2=sc.next();
//              }
//
//      }
//      return wordsHashMapOfNames;
//  }

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
            while (word2.equals("")){
                word2 = sc.next();
                word2 = word2.substring(0).toLowerCase();
                word2 = wordWithIgnores(word2, charsToIgnore);
            }
            word = word + " " + word2;
            wordsHashMap2Words.putIfAbsent(word, 0);
            Integer put = wordsHashMap2Words.get(word);
            put++;
            wordsHashMap2Words.put(word, put);
        }
        return wordsHashMap2Words;
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
