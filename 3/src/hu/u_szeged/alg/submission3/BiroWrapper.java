package hu.u_szeged.alg.submission3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BiroWrapper {

    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("be.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("ki.txt"));

            List<Integer> list = new LinkedList<Integer>();
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
            int[] events = list.stream().mapToInt(Integer::intValue).toArray();

            int[] answered = Main.rejectionOrder(events);
            if (answered.length > 0) {
                writer.write("" + answered[0]);
            }
            for (int i = 1; i < answered.length; i++) {
                writer.write(" " + answered[i]);
            }
            writer.write("\n");

            reader.close();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
