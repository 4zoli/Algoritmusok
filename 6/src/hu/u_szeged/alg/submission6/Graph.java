package hu.u_szeged.alg.submission6;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Node> getAllNodes() {
        return nodes;
    }

    public List<Edge> getAllEdges() {
        return edges;
    }

    public int getNodeCount() {
        return nodes != null ? nodes.size() : 0;
    }

    public int getEdgeCount() {
        return edges != null ? edges.size() : 0;
    }

    public List<Edge> getEdgesForNode(Node node) {
        List<Edge> res = new LinkedList<>();
        for (Edge e : this.getAllEdges()) {
            if (e.getSource().equals(node) || e.getDestination().equals(node)) {
                res.add(e);
            }
        }

        return res;
    }
}
