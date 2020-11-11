
import com.sun.source.tree.Tree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SemAnalizer {
    static TreeMap<Integer, ArrayList<String>> maxWords = new TreeMap<>();
    static TreeMap<Integer, ArrayList<String>> maxWordsWithLetterCnt = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findMaxWords(Reader.read("borbala.txt")));
        System.out.println(findMaxWordsWithLetterCnt(Reader.read("borbala.txt"),1));
        System.out.println(findMaxWords(Reader.read2Words("borbala.txt")));

    }
    //2.    Gyűjtsd ki egy szöveg 10 leggyakoribb 2-3-4 szavas szófordulatát!
    public static TreeMap<Integer, ArrayList<String>> findMaxWordsWithLetterCnt(HashMap<String, Integer> words,int letterCnt) {
        int maxCnt = Integer.MAX_VALUE;
        for (int i = 0; i < 10; ) {
            Integer actuelMaxCnt = findMaxWordsUnderMaxCntWithLetterCnt(words, maxCnt,letterCnt);
            System.out.println(actuelMaxCnt);
            maxWordsWithLetterCnt.putIfAbsent(actuelMaxCnt, new ArrayList<>());
            for (String s : words.keySet()) {
                if (words.get(s).equals(actuelMaxCnt)  && s.toCharArray().length==(letterCnt)) {
                    maxWordsWithLetterCnt.get(actuelMaxCnt).add(s);
                    i++;
                }
            }
            if (actuelMaxCnt<0){
                break;}
            maxCnt = actuelMaxCnt;


        }
        return maxWordsWithLetterCnt;
    }

    public static Integer findMaxWordsUnderMaxCntWithLetterCnt(HashMap<String, Integer> words, int underMaxCnt,int letterCnt) {
        int max = Integer.MIN_VALUE;
        for (String s : words.keySet()) {
            if ((!s.equals("")) && words.get(s) > max && words.get(s) < underMaxCnt && s.toCharArray().length==(letterCnt) ) {
                max = words.get(s);
            }
//            System.out.println(max);
        }
        return max;
    }

    //   1. Gyűjtsd ki egy szöveg 10 leggyakoribb szavát!
    public static TreeMap<Integer, ArrayList<String>> findMaxWords(HashMap<String, Integer> words) {
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
