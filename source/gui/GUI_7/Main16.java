package gui.GUI_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main16 {

    public static void main(String[] args) {
        String file = "/Users/maksymbilyk/Desktop/programming/PJAIT/JAVA1/source/gui/GUI_7/slowa.txt";
        for (Map.Entry<String, Long> e : new Slowa(file))
            System.out.println(
                    e.getKey() + " -> " + e.getValue());

    }

}

class Slowa implements Iterable<Map.Entry<String, Long>> {

    Map<String, Long> words;

    public Slowa(String filename) {
        words = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            findWords(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void findWords(BufferedReader reader) throws IOException {
        String currentLine = "";

        List<String> strings = new ArrayList<>();

        while ((currentLine = reader.readLine()) != null) {
            String[] d = currentLine.split("\\P{L}+");
            strings.addAll(Arrays.asList(d));
        }

        words = strings.stream().collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting()));

        reader.close();
    }

    public Map<String, Long> getWords() {
        return this.words;
    }

    @Override
    public Iterator<Map.Entry<String, Long>> iterator() {
        return this.words.entrySet().iterator();
    }
}