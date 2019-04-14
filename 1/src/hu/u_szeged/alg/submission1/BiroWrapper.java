package hu.u_szeged.alg.submission1;

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

            line = reader.readLine();

            String[] strArr = line.split(" ");
            int[] arr = new int[strArr.length];

            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }

            System.out.println(Main.binarySearchWrapper(arr, key));
            writer.write(Main.binarySearchWrapper(arr, key) + "\n");

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
