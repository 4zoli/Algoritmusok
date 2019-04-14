package hu.u_szeged.alg.submission6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private Graph graph;
    private int[] components;
    private Edge[] allEdges;
    private List<Edge> chosenEdges;

    public Main(Graph graph) {
        this.graph = graph;
    }

    private void init() {
        components = new int[graph.getNodeCount()];
        for (int i = 0; i < components.length; i++) {
            components[i] = i;
        }

        allEdges = graph.getAllEdges().toArray(new Edge[graph.getEdgeCount()]);
        Arrays.sort(allEdges);
        chosenEdges = new LinkedList<>();
    }

    public void perform() {
        this.init();
           
        for(int i = 0; i < allEdges.length; i++) {
        	 Edge e = allEdges[i];
             int src = e.getSource().getId();
             int tgt = e.getDestination().getId();
        
             if (components[src] != components[tgt]) {
            	 chosenEdges.add(e);
            	 int source = components[src];
            	 int destination = components[tgt];            
            	 
                 for (int j = 0; j < components.length; j++) {
                     if (components[j] == source) {
                         components[j] = destination;
                     	}
                 	}
             	}
             }
        }    

    public int getChosenEdgeCount() {
        return chosenEdges != null ? chosenEdges.size() : 0;
    }
	
	    public List<Edge> getChosenEdges() {
        return chosenEdges;
    }

    public int getTotalLength() {
        if (chosenEdges == null) {
            return 0;
        }

        int totalLength = 0;
        for (Edge e : chosenEdges) {
            totalLength += e.getWeight();
        }
        return totalLength;
    }
}
