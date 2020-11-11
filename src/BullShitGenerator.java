import java.io.FileNotFoundException;
import java.util.*;

public class BullShitGenerator {
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
        for (int i = 0; i < words.size(); i++) {
            int nr = rndmzr.nextInt(words.size());
            Set<Integer> nrsUsed = new HashSet<>();
            nrsUsed.add(nr);
            text.append(words.get(nr));
            if (i != words.size() - 1) {
                text.append(" ");
            }
        }
        return text.toString();
    }
}
