import com.sun.source.tree.Tree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SemAnalizer {
    static TreeMap<Integer, ArrayList<String>> maxWords = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findMaxWords(Reader.read("PairProject.From11.11/borbala.txt")));
    }
//2.    Gyűjtsd ki egy szöveg 10 leggyakoribb 2-3-4 szavas szófordulatát!


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
