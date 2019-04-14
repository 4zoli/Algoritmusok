package hu.u_szeged.alg.submission6;

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
            Graph graph = loadGraph("be.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter("ki.txt"));

            Main kr = new Main(graph);
            kr.perform();

            List<Edge> res = kr.getChosenEdges();

            for (Edge e : res) {
                writer.write(e.getId() + "\n");
            }
            writer.write(kr.getTotalLength() + "\n");

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Graph loadGraph(String filename) throws IOException {
        String line;
        String[] parts;

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        line = reader.readLine();
        parts = line.split(" ");

        int nodeCnt = Integer.parseInt(parts[0]);
        int edgeCnt = Integer.parseInt(parts[1]);

        List<Node> nodes = new ArrayList<>(nodeCnt);
        for (int i = 0; i < nodeCnt; i++) {
            line = reader.readLine();
            nodes.add(new Node(i, line));
        }

        List<Edge> edges = new ArrayList<>(edgeCnt);
        for (int i = 0; i < edgeCnt; i++) {
            line = reader.readLine();
            parts = line.split(" ");
            Node srcNode = nodes.get(Integer.parseInt(parts[0]));
            Node tgtNode = nodes.get(Integer.parseInt(parts[1]));
            edges.add(new Edge(Integer.toString(i), srcNode, tgtNode, Integer.parseInt(parts[2])));
        }

        reader.close();

        return new Graph(nodes, edges);
    }

}
