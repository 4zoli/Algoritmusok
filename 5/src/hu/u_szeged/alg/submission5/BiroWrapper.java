package hu.u_szeged.alg.submission5;

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

            List<Dwarf> dwarfsList = new ArrayList<>();

            String line = reader.readLine();
            String[] ranks = line.split(" ");
            int[] teamMembers = new int[ranks.length];
            for (int i = 0; i < ranks.length; i++) {
                teamMembers[i] = Integer.parseInt(ranks[i]);
            }
            while ((line = reader.readLine()) != null) {
                String[] c = line.trim().split(" ");
                dwarfsList.add(new Dwarf(c[0],
                        Integer.parseInt(c[1]),
                        Integer.parseInt(c[2]),
                        Integer.parseInt(c[3])
                ));
            }

            Dwarf[] dwarfs = new Dwarf[dwarfsList.size()];
            dwarfsList.toArray(dwarfs);

            String[] answered = Main.buildTeamWrapper(dwarfs, teamMembers);
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
