package hu.u_szeged.alg.submission4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BiroWrapper {

    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("be.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("ki.txt"));

            List<Command> commands = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] c = line.trim().split(" ");
                commands.add(new Command(c[0], Long.parseLong(c[1])));
            }
            Command[] commandsArr = new Command[commands.size()];
            commands.toArray(commandsArr);

            long[] answered = Main.HarryThePotter(commandsArr);
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
