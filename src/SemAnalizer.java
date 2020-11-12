import com.sun.source.tree.Tree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SemAnalizer {
//    static TreeMap<Integer, ArrayList<String>> maxWords = new TreeMap<>();
//    static TreeMap<Integer, ArrayList<String>> maxWordsWithLetterCnt = new TreeMap<>();
//    static TreeMap<Integer, ArrayList<String>> maxWords2Words = new TreeMap<>();
//    static TreeMap<Integer, ArrayList<String>> maxWordsFilter = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(findMaxWords(Reader.readHunFirstNames("borbala.txt")));
//        System.out.println(findMaxWordsWithLetterCnt(Reader.read("borbala.txt"),1));
//        System.out.println(findMaxWords(Reader.read("borbala.txt")));
//        System.out.println(filteredMoreThan15Words(Reader.read("borbala.txt")));
    }


    // nem a forrászövegünkre jellemző szavak szűrése
    public static TreeMap<Integer, ArrayList<String>> filteredMoreThan15Words(HashMap<String, Integer> words) {
        TreeMap<Integer, ArrayList<String>> maxWordsFilter = new TreeMap<>();
        for (int i = 4; i < 20; i++) {
            for (Integer integer : findMaxWordsWithLetterCnt(words, i).keySet()) {
                if (integer > 30) {
                    for (int j = 0; j < findMaxWordsWithLetterCnt(words, i).get(integer).size(); j++) {
                        String word = findMaxWordsWithLetterCnt(words, i).get(integer).get(j);
                        if (word.equals("hogy") || word.equals("volt") || word.equals("csak") || word.equals("aztán") || word.equals("mint") || word.equals("hanem") || word.equals("mert") || word.equals("hogy")
                                || word.equals("azután") || word.equals("mintha") || word.equals("vagy") || word.equals("valami") || word.equals("pedig") || word.equals("annak") || word.equals("minden") || word.equals("most") || word.equals("mely")
                        ) {
                        } else {
                            maxWordsFilter.putIfAbsent(integer, new ArrayList<>());
                            maxWordsFilter.get(integer).add(word);
                        }
                    }
                }
            }
        }
        return maxWordsFilter;
    }


//    Gyűjtsd ki egy szöveg 10 leggyakoribb nevét!
//    még nincs kész

    //2.    Gyűjtsd ki egy szöveg 10 leggyakoribb 2-3-4  szófordulatát!
//        findMaxWordsOf2Words(Reader.read2Words("borbala.txt"));


    // Gyűjts ki a leggyakoribb "letterCnt"  betűs szót.
    public static TreeMap<Integer, ArrayList<String>> findMaxWordsWithLetterCnt(HashMap<String, Integer> words, int letterCnt) {
        TreeMap<Integer, ArrayList<String>> maxWordsWithLetterCnt = new TreeMap<>();

        int maxCnt = Integer.MAX_VALUE;
        for (int i = 0; i < 10; ) {
            Integer actuelMaxCnt = findMaxWordsUnderMaxCntWithLetterCnt(words, maxCnt, letterCnt);
            maxWordsWithLetterCnt.putIfAbsent(actuelMaxCnt, new ArrayList<>());
            for (String s : words.keySet()) {
                if (words.get(s).equals(actuelMaxCnt) && s.toCharArray().length == (letterCnt)) {
                    maxWordsWithLetterCnt.get(actuelMaxCnt).add(s);
                    i++;
                }
            }
            if (actuelMaxCnt < 0) {
                break;
            }
            maxCnt = actuelMaxCnt;
        }
        maxWordsWithLetterCnt.remove(Integer.MIN_VALUE);
        return maxWordsWithLetterCnt;
    }

    public static Integer findMaxWordsUnderMaxCntWithLetterCnt(HashMap<String, Integer> words, int underMaxCnt, int letterCnt) {
        int max = Integer.MIN_VALUE;
        for (String s : words.keySet()) {
            if ((!s.equals("")) && words.get(s) > max && words.get(s) < underMaxCnt && s.toCharArray().length == (letterCnt)) {
                max = words.get(s);
            }
        }
        return max;
    }

    public static TreeMap<Integer, ArrayList<String>> findMaxWordsOf2Words(HashMap<String, Integer> words) {
        TreeMap<Integer, ArrayList<String>> maxWords = new TreeMap<>();
        TreeMap<Integer, ArrayList<String>> maxWords2Words = new TreeMap<>();
        int maxCnt = Integer.MAX_VALUE;
        for (int i = 0; i < 10; ) {
            Integer actuelMaxCnt = findMaxWordsUnderMaxCnt(words, maxCnt);
            maxWords2Words.putIfAbsent(actuelMaxCnt, new ArrayList<>());
            for (String s : words.keySet()) {
                if (words.get(s).equals(actuelMaxCnt)) {
                    maxWords2Words.get(actuelMaxCnt).add(s);
                    i++;
                }
            }
            maxCnt = actuelMaxCnt;
        }
        return maxWords;
    }

    //   1. Gyűjtsd ki egy szöveg 10 leggyakoribb szavát!
    public static TreeMap<Integer, ArrayList<String>> findMaxWords(HashMap<String, Integer> words) {
        TreeMap<Integer, ArrayList<String>> maxWords = new TreeMap<>();
        int maxCnt = Integer.MAX_VALUE;
        for (int i = 0; i < 10; ) {
            Integer actuelMaxCnt = findMaxWordsUnderMaxCnt(words, maxCnt);
            maxWords.putIfAbsent(actuelMaxCnt, new ArrayList<>());
            for (String s : words.keySet()) {
                if (words.get(s).equals(actuelMaxCnt)) {
                    maxWords.get(actuelMaxCnt).add(s);
                    i++;
                }
            }
            maxCnt = actuelMaxCnt;
        }
        return maxWords;
    }

    public static Integer findMaxWordsUnderMaxCnt(HashMap<String, Integer> words, int underMaxCnt) {
        int max = Integer.MIN_VALUE;
        for (String s : words.keySet()) {
            if ((!s.equals("")) && words.get(s) > max && words.get(s) < underMaxCnt) {
                max = words.get(s);
            }
        }
        return max;
    }
}
