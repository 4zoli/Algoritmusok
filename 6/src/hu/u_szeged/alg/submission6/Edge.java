package hu.u_szeged.alg.submission6;

/**
 * Elek reprezentalasara szolgalo osztaly
 */
public class Edge implements Comparable<Edge> {

    private final String id;
    private final Node source;
    private final Node destination;
    private final int weight;

    public Edge(String id, Node source, Node destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Node getDestination() {
        return destination;
    }

    public Node getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return id + " (" + source + " " + destination + ") (" + weight + ")";
    }

    @Override
    public int compareTo(Edge arg0) {
        return Integer.compare(weight, arg0.getWeight());
    }

}
