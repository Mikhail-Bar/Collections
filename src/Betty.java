import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Betty {
    public static void main(String[] args) {
        TreeSet<String> treeSet =new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("src/data/betty.txt"))) {

            String s;
            do {
                s = br.readLine();
                sb.append(s);
                sb.append(System.lineSeparator());
            }
            while (s!= null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = sb.toString();
        content = content.replaceAll("[^A-Za-z]"," ");
        String[] words = content.split(" ");
        //System.out.println(Arrays.toString(words));
        for (String s:words) {
            s = s.trim();
            if (s.length()!=0 && (s.charAt(0)=='b' || s.charAt(0)=='B'))
                treeSet.add(s);
        }
        System.out.println(treeSet.toString());
    }
}
