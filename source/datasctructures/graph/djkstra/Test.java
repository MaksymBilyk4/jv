package datasctructures.graph.djkstra;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        WeightedGraph<String> weightedGraph = new WeightedGraph<>();

        weightedGraph.add("A", "C", 7);
        weightedGraph.add("C", "D", 5);
        weightedGraph.add("A", "B", 3);
        weightedGraph.add("B", "D", 8);
        weightedGraph.add("B", "E", 1);
        weightedGraph.add("E", "F", 5);
        weightedGraph.add("F", "D", 1);
        weightedGraph.add("D", "Random", 100);

        Node<String> node = weightedGraph.getNode("D");
//        System.out.println(node);
//        System.out.println(node.getEdges());
//        System.out.println(node.getParents());

        LinkedList<String> shortestPath = weightedGraph.getShortestPath("A", "D");
        System.out.println(shortestPath);
    }

}
