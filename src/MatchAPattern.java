import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class MatchAPattern {
    public static List<List<Integer>> perform(String p_filename, String p_pattern) {
        List<List<Integer>> res = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./" + p_filename));
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line is " + line);
                // Search for pattern in line (ignore case)
                int index = line.toLowerCase().indexOf(p_pattern);
                while (index >= 0) {
                    List<Integer> item = new LinkedList<>();
                    item.add(lineNumber);
                    item.add(index + 1);
                    res.add(item);
                    // Print position number of match
                    System.out.println("Match found at position " + lineNumber + +(index + 1));
                    // index = line.toLowerCase().indexOf(p_pattern, index + 1); // check for next
                    // match
                }
                lineNumber++;
            }
        } catch (Exception e) {

        } finally {
        }
        // try {
        // reader.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        return res;
    }
}