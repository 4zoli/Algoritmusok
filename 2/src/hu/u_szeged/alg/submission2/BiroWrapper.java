package hu.u_szeged.alg.submission2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BiroWrapper {

    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("be.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("ki.txt"));

            String line = reader.readLine();
            int key = Integer.parseInt(line);

            System.out.println(Main.legolasStepCountingWrapper(key));
            writer.write(Main.legolasStepCountingWrapper(key) + "\n");

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
